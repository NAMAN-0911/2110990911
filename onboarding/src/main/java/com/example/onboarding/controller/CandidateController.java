package com.example.onboarding.controller;
import com.example.onboarding.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.service.CandidateService;
import com.example.onboarding.dto.UpdateStatusRequest;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;




import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateService candidateService, CandidateRepository candidateRepository) {
        this.candidateService = candidateService;
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateRepository.save(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    // GET /api/candidates/hired - Get all hired candidates
    @GetMapping("/hired")
    public List<Candidate> getAllHiredCandidates() {
        return candidateService.getAllCandidates();
    }

    // GET /api/candidates/{id} - Get candidate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Optional<Candidate> candidate = candidateService.getCandidateById(id);
        return candidate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCandidateCount() {
        long count = candidateService.getCandidateCount();
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Candidate> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest request
    ) {
        Candidate updated = candidateService.updateCandidateStatus(id, request.getStatus());
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Candidate>> getCandidatesByStatus(@PathVariable String status) {
        List<Candidate> candidates = candidateService.getCandidatesByStatus(status);
        return ResponseEntity.ok(candidates);
    }




}