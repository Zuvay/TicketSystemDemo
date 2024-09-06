package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.service.IssueService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MASTER
@RestController
@RequestMapping("/test")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @GetMapping("/testingsessionid")
    public String session(HttpServletRequest http){
        return "Session ID ->" + http.getSession().getId();
    }

    @PostMapping("/save")
    public Issue saveUser(@RequestBody Issue issue){
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
