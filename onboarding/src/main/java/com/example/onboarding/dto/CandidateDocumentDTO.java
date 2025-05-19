package com.example.onboarding.dto;

public class CandidateDocumentDTO {
    private String documentType;
    private String fileUrl;

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
}