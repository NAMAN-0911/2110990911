package com.example.onboarding.repository;

import com.example.onboarding.entity.CandidateDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDocumentRepository extends JpaRepository<CandidateDocument, Long> {
    List<CandidateDocument> findByCandidateId(Long candidateId);
}