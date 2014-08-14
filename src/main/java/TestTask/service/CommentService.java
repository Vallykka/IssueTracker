package TestTask.service;

import TestTask.model.Comment;
import TestTask.model.Issue;

import java.util.List;

public interface CommentService {

    public List<Comment> findAll(String issueId);

    public void createComment(Comment comment);
}
