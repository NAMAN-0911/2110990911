package com.example.onboarding.service;

import com.example.onboarding.dto.CandidateDocumentDTO;
import com.example.onboarding.entity.CandidateDocument;

import java.util.List;

public interface CandidateDocumentService {
    CandidateDocument uploadDocument(Long candidateId, CandidateDocumentDTO dto);
    CandidateDocument verifyDocument(Long documentId);
    List<CandidateDocument> getDocumentsForCandidate(Long candidateId);
}