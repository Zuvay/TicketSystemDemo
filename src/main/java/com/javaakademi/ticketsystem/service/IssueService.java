package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.entity.User;
import com.javaakademi.ticketsystem.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserService usersService;

    public Issue saveIssue(Issue issue) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();//İsmi böyle aldık

        User author = usersService.findByUsername(username); //İsme sahip kişiyi obje olarak bulduk

        issue.setAuthor(author); //issue'nin post kısmına yansımadan yazan kişiyi verdik
        issue.setAuthorName(author.getUsername());
        issue.setAuthorTitle(author.getPersonalTitle());
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public List<Issue> getSpesificUserIssues(String authorName){
        return issueRepository.findByAuthorName(authorName);
    }

    public void deleteIssue(String id) {
        issueRepository.deleteById(id);
    }

    public void updateIssue(String id, Issue issue) throws Exception {
        Optional<Issue> optionalIssue = issueRepository.findById(id);
        if (optionalIssue.isPresent()) {
            Issue willUpdatedIssue = optionalIssue.get();
            willUpdatedIssue.setIssuetitle(issue.getIssuetitle()); // Başlığı güncelle
            willUpdatedIssue.setIssuedescription(issue.getIssuedescription()); // Açıklamayı güncelle
            issueRepository.save(willUpdatedIssue); // Nesneyi veritabanına kaydet
        } else {
            // Eğer IDye sahip bi obje yoksa
            throw new Exception("Issue not found with id: " + id);
        }
    }
}
