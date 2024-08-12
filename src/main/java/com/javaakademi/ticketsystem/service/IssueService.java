package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public void deleteIssue(String id){
        issueRepository.deleteById(id);
    }
}
