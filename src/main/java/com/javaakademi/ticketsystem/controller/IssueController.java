package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.entity.Users;
import com.javaakademi.ticketsystem.service.IssueService;
import com.javaakademi.ticketsystem.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MASTER
@RestController
@RequestMapping("/test")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/testingsessionid")
    public String session(HttpServletRequest http){
        return "Session ID ->" + http.getSession().getId();
    }

    @PostMapping("/save")
    public Issue saveUser(@RequestBody Issue issue){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//İsmi böyle aldık

        Users author = usersService.findByUsername(username); //İsme sahip kişiyi obje olarak bulduk

        issue.setAuthor(author); //issue'nin post kısmına yansımadan yazan kişiyi verdik
        issue.setAuthorName(author.getUsername());
        issue.setAuthorTitle(author.getPersonalTitle());
        return issueService.saveIssue(issue);

    }

    @GetMapping("/getspesific/{username}")
    public List<Issue> getSpesificUserIssues(@PathVariable("username") String authorName){
        return issueService.getSpesificUserIssues(authorName);
    }

    @GetMapping("/read")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIssue(@PathVariable("id") String id) {
        issueService.deleteIssue(id);
    }

    @PutMapping("/update/{id}")
    public void updateIssue(@PathVariable("id") String id, @RequestBody Issue issue) throws Exception {
        issueService.updateIssue(id, issue);
    }
}
