package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @PostMapping("/save")
    public void saveIssue(@RequestBody Issue issue){
        issueService.saveIssue(issue);
    }

    @GetMapping("/read")
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIssue(@PathVariable("id") String id){
        issueService.deleteIssue(id);
    }
    @PutMapping("/update/{id}")
    public void updateIssue(@PathVariable("id") String id, @RequestBody Issue issue) throws Exception {
        issueService.updateIssue(id,issue);
    }
}
