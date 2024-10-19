package com.javaakademi.ticketsystem.Issue.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private int id;
    private String username;
    private String issueTitle;
    private String issueDescription;
}
