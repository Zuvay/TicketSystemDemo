package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.response.IssueRequest;
import com.javaakademi.ticketsystem.response.IssueResponse;
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
    public IssueResponse saveUser(@RequestBody IssueRequest issueRequest){
        return issueService.saveIssue(issueRequest);
    }

    @GetMapping("/getspesific/{username}")
    public List<IssueResponse> getSpesificUserIssues(@PathVariable("username") String username){
        return issueService.getSpesificUserIssues(username);
    }

    @GetMapping("/read")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/responsetest")
    public List<IssueResponse> getResponseIssue(){
        return issueService.getIssueResponse();
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
