package TestTask.controller;

import TestTask.model.Comment;
import TestTask.model.Issue;
import TestTask.model.Status;
import TestTask.service.impl.CommentServiceImpl;
import TestTask.service.impl.IssueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class IssueViewController {

    @Autowired
    private IssueServiceImpl issueService;

    @Autowired
    private CommentServiceImpl commentService;

    @ModelAttribute("issue")
    public Issue getIssue(String id) {
        return issueService.findById(id);
    }

    @ModelAttribute("getComments")
    public List<Comment> getComment(String id) {return commentService.findAll(id);}

    @ModelAttribute("allStatus")
    public List<String> getAllStatus() {
        List<String> list = new LinkedList<String>();
        for (Status status : Status.values()) {
            list.add(String.valueOf(status));
        }
        return list;
    }

    @ModelAttribute("comment.status")
    public String getStatus() {return "";}

    @RequestMapping(value = "/issueView", method = RequestMethod.GET)
    public String getIssueViewPage(@RequestParam(value = "id", required = true) String id, Comment comment) {
        return "issueView";
    }

    @RequestMapping(value = "/issueView", params = {"createComment"}, method = RequestMethod.POST)
    public String addComment (@RequestParam(value = "id", required = true) String id, @ModelAttribute("issue") Issue issue,
                              Comment comment, HttpServletRequest request, ModelMap model) {
        comment.setIssueId(id);
        commentService.createComment(comment);
        if (request.isUserInRole("ROLE_ADMIN")) {
            issue.setStatus(Status.valueOf(comment.getStatus()));
            issueService.updateIssue(issue);
        }
        model.clear();
        return "redirect:issueView?id="+id;
    }

}
