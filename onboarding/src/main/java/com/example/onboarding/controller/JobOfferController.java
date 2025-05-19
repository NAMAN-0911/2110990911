package com.example.onboarding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onboarding.entity.Candidate;
import com.example.onboarding.repository.CandidateRepository;
import com.example.onboarding.service.EmailPublisherService;

@RestController
@RequestMapping("/api/candidates")
public class JobOfferController {

    private final CandidateRepository candidateRepository;
    private final EmailPublisherService publisherService;

    public JobOfferController(CandidateRepository candidateRepository, EmailPublisherService publisherService) {
        this.candidateRepository = candidateRepository;
        this.publisherService = publisherService;
    }

    @PostMapping("/{id}/notify-job-offer")
    public ResponseEntity<String> notifyCandidate(@PathVariable Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        publisherService.sendStatusUpdateEmail(candidate);

        return ResponseEntity.ok("Job offer email sent (queued)");
    }
}