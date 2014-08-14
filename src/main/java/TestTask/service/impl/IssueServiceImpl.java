package TestTask.service.impl;

import TestTask.db.IssueDAO;
import TestTask.model.Issue;
import TestTask.model.Status;
import TestTask.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueDAO issueDAO;

    @Override
    public List<Issue> findAll() {return issueDAO.findAll();}

    @Override
    public Issue findById(String id) {
        return issueDAO.findById(id);
    }

    @Override
    public void createIssue(Issue issue) {
        issue.setStatus(Status.CREATED);
        issue.setDateTime(Calendar.getInstance().getTime());
        issueDAO.createIssue(issue);
    }

    @Override
    public void updateIssue(Issue issue) {
        issueDAO.updateIssue(issue.getStatus(), issue.getId());
    }


}
