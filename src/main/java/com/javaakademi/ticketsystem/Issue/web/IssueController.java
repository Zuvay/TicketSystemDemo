package com.javaakademi.ticketsystem.Issue.web;

import com.javaakademi.ticketsystem.Issue.api.IssueMapper;
import com.javaakademi.ticketsystem.Issue.api.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public IssueResponse create(@RequestBody IssueRequest request) {
        return IssueMapper.toResponse(issueService.create(IssueMapper.toDto(request)));
    }

    @PutMapping("/{id}")
    public IssueResponse update(@PathVariable String id, @RequestBody IssueRequest request) {
        return IssueMapper.toResponse(issueService.update(id, IssueMapper.toDto(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        issueService.delete(id);
    }

    @GetMapping("/{id}")
    public IssueResponse getById(@PathVariable String id) {
        return IssueMapper.toResponse(issueService.getById(id));
    }

    @GetMapping
    public List<IssueResponse> getAll() {
        return issueService.getAll().stream()
                .map(IssueMapper::toResponse)  // Her bir IssueDto'yu IssueResponse'a çeviriyoruz
                .collect(Collectors.toList());
    }

}
