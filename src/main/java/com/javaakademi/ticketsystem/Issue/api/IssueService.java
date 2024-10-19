package com.javaakademi.ticketsystem.Issue.api;

import com.javaakademi.ticketsystem.Issue.impl.Issue;

import java.util.List;

public interface IssueService {
    IssueDto create(IssueDto dto);

    IssueDto update(String id, IssueDto issueDto);

    IssueDto getById(String id);

    void delete(String id);
    List<IssueDto> getAll();
}
