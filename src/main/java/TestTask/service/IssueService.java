package TestTask.service;

import TestTask.model.Issue;

import java.util.List;

public interface IssueService {

    public List<Issue> findAll ();

    public Issue findById (String id);

    public void createIssue (Issue issue);

    public void updateIssue (Issue issue);
}
