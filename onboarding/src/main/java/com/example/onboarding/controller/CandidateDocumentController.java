package com.example.onboarding.controller;

import com.example.onboarding.dto.CandidateDocumentDTO;
import com.example.onboarding.entity.CandidateDocument;
import com.example.onboarding.service.CandidateDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateDocumentController {

    private final CandidateDocumentService documentService;

    public CandidateDocumentController(CandidateDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/{id}/upload-document")
    public ResponseEntity<CandidateDocument> uploadDocument(@PathVariable Long id,
                                                            @RequestBody CandidateDocumentDTO dto) {
        CandidateDocument doc = documentService.uploadDocument(id, dto);
        return ResponseEntity.ok(doc);
    }

    @PutMapping("/{candidateId}/verify-document/{documentId}")
    public ResponseEntity<CandidateDocument> verifyDocument(@PathVariable Long documentId) {
        CandidateDocument doc = documentService.verifyDocument(documentId);
        return ResponseEntity.ok(doc);
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity<List<CandidateDocument>> getDocuments(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.getDocumentsForCandidate(id));
    }
}