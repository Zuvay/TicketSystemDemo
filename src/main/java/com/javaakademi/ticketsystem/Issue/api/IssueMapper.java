package com.javaakademi.ticketsystem.Issue.api;

import com.javaakademi.ticketsystem.Issue.web.IssueRequest;
import com.javaakademi.ticketsystem.Issue.web.IssueResponse;

public class IssueMapper {

    public static IssueDto toDto(IssueRequest issueRequest){
        return IssueDto.builder()
                .issueDescription(issueRequest.getIssueDescription())
                .issueTitle(issueRequest.getIssueTitle())
                .username(issueRequest.getUsername())
                .build();
    }
    public static IssueResponse toResponse(IssueDto issueDto){
        return IssueResponse.builder()
                .issueDescription(issueDto.getIssueDescription())
                .issueTitle(issueDto.getIssueTitle())
                .username(issueDto.getUsername())
                .build();
    }
}
