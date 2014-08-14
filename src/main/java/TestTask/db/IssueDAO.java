package TestTask.db;

import TestTask.model.Issue;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IssueDAO {

    String INSERT = "INSERT INTO issue (title, author, description, dateTime, status) " +
            "VALUES (#{title}, #{author}, #{description}, #{dateTime}, #{status})";

    String STATUS_UPDATE = "UPDATE issue SET status = #{status} WHERE id = #{issueId}";

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache=true)
    public void createIssue(Issue issue);

    @Update(STATUS_UPDATE)
    public void updateIssue(@Param("status") String status, @Param("issueId") String issueId);

    @Select("SELECT * FROM issue")
    List<Issue> findAll();

    @Select("SELECT * FROM issue WHERE id = #{issueId}")
    Issue findById(@Param("issueId") String issueId);

}
