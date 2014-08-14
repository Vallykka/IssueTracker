package TestTask.controller;

import TestTask.model.Issue;
import TestTask.service.impl.IssueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IssuesController {

    @Autowired
    private IssueServiceImpl issueService;

    @ModelAttribute("getIssues")
    public List<Issue> getIssues() {
        return this.issueService.findAll();
    }

    @RequestMapping(value = "/")
    public String issues() {
        return "issues";
    }

    @RequestMapping(value = "/login")
    public String login() { return "login"; }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


}
