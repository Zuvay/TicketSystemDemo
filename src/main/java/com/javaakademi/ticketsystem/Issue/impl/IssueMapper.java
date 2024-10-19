package com.javaakademi.ticketsystem.Issue.impl;

import com.javaakademi.ticketsystem.Issue.api.IssueDto;
import com.javaakademi.ticketsystem.Issue.web.IssueResponse;

public class IssueMapper {
    public IssueMapper(){}

    public static IssueDto toDto(Issue issue){
        return IssueDto.builder()
                .id(issue.getId())
                .issueDescription(issue.getIssueDescription())
                .issueTitle(issue.getIssueTitle())
                .username(issue.getUsername())
                .build();
    }

    public static IssueResponse toResponse(IssueDto issueDto){
        return IssueResponse.builder()
                .issueDescription(issueDto.getIssueDescription())
                .issueTitle(issueDto.getIssueTitle())
                .username(issueDto.getUsername())
                .build();
    }
    public static Issue toEntity(IssueDto issueDto){
        Issue issue = new Issue();
        issue.setId(issueDto.getId());
        issue.setIssueDescription(issueDto.getIssueDescription());
        issue.setIssueTitle(issueDto.getIssueTitle());
        issue.setUsername(issueDto.getUsername());
        return issue;
    }
}
