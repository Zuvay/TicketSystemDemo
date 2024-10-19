package com.javaakademi.ticketsystem.Issue.web;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueResponse {
    private String username;
    private String issueTitle;
    private String issueDescription;
}
