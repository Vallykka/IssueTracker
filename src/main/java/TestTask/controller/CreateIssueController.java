package TestTask.controller;

import TestTask.model.Issue;
import TestTask.service.impl.IssueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateIssueController {

    @Autowired
    private IssueServiceImpl issueService;

    @ModelAttribute("issue")
    public Issue getIssue() {
        return new Issue();
    }

    @RequestMapping(value = "/createIssue")
    public String createIssue (Issue issue) {
        return "createIssue";
    }

    @RequestMapping(value = "/createIssue", params = {"create"}, method = RequestMethod.POST)
    public String saveIssue(Issue issue) throws Exception {
        issueService.createIssue(issue);
        return "redirect:/";
    }

}
