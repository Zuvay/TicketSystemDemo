package com.javaakademi.ticketsystem.Issue.impl;

import com.javaakademi.ticketsystem.Issue.api.IssueDto;
import com.javaakademi.ticketsystem.Issue.api.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//servis dto alır dto döner
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    @Override
    public IssueDto create(IssueDto dto) {
        return IssueMapper.toDto(issueRepository.save(IssueMapper.toEntity(dto)));
    }

    @Override
    public IssueDto update(String id, IssueDto issueDto) {
        Issue existingIssue = issueRepository.findById(id).orElseThrow();

        existingIssue.setIssueTitle(issueDto.getIssueTitle());
        existingIssue.setIssueDescription(issueDto.getIssueDescription());
        existingIssue.setUsername(issueDto.getUsername());

        return IssueMapper.toDto(issueRepository.save(existingIssue));
    }

    @Override
    public IssueDto getById(String id) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        return IssueMapper.toDto(issue);
    }

    @Override
    public void delete(String id) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issueRepository.delete(issue);
    }

    @Override
    public List<IssueDto> getAll() {
        return issueRepository.findAll().stream()
                .map(IssueMapper::toDto)
                .collect(Collectors.toList());
    }
}
