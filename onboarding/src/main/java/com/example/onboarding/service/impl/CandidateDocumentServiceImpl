package com.example.onboarding.service.impl;

import com.example.onboarding.dto.CandidateDocumentDTO;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.CandidateDocument;
import com.example.onboarding.repository.CandidateDocumentRepository;
import com.example.onboarding.repository.CandidateRepository;
import com.example.onboarding.service.CandidateDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateDocumentServiceImpl implements CandidateDocumentService {

    private final CandidateRepository candidateRepository;
    private final CandidateDocumentRepository documentRepository;

    public CandidateDocumentServiceImpl(CandidateRepository candidateRepository, CandidateDocumentRepository documentRepository) {
        this.candidateRepository = candidateRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public CandidateDocument uploadDocument(Long candidateId, CandidateDocumentDTO dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        CandidateDocument doc = new CandidateDocument();
        doc.setCandidate(candidate);
        doc.setDocumentType(dto.getDocumentType());
        doc.setFileUrl(dto.getFileUrl());
        doc.setVerified(false);

        return documentRepository.save(doc);
    }

    @Override
    public CandidateDocument verifyDocument(Long documentId) {
        CandidateDocument doc = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        doc.setVerified(true);
        return documentRepository.save(doc);
    }

    @Override
    public List<CandidateDocument> getDocumentsForCandidate(Long candidateId) {
        return documentRepository.findByCandidateId(candidateId);
    }
}
