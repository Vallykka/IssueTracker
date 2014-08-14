package TestTask.db;

import TestTask.model.Comment;
import TestTask.model.Issue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDAO {

    String INSERT = "INSERT INTO comment (author, text, dateTime, status, issueId) " +
            "VALUES (#{author}, #{text}, #{dateTime}, #{status}, #{issueId})";

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache=true)
    public void createComment(Comment comment);

    @Select("SELECT * FROM comment WHERE issueId = #{issueId}")
    List<Comment> findAll(@Param("issueId")String issueId);

    @Select("DELETE * FROM comment WHERE id = #{commentId}")
    Issue deleteComment(@Param("issueId") String issueId);
}
