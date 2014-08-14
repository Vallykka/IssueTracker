package TestTask.service.impl;

import TestTask.db.CommentDAO;
import TestTask.model.Comment;
import TestTask.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> findAll(String issueId) {
        return commentDAO.findAll(issueId);
    }

    @Override
    public void createComment(Comment comment) {
        comment.setDateTime(Calendar.getInstance().getTime());
        commentDAO.createComment(comment);
    }

}
