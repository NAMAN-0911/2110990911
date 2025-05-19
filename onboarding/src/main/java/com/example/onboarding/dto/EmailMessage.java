package com.example.onboarding.dto;

import java.io.Serializable;

public class EmailMessage implements Serializable {
    private Long candidateId;
    private String to;
    private String subject;
    private String body;

    // Constructors
    public EmailMessage() {}

    public EmailMessage(Long candidateId, String to, String subject, String body) {
        this.candidateId= candidateId;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}