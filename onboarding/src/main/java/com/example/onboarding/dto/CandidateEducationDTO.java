package com.example.onboarding.dto;

public class CandidateEducationDTO {

    private Long candidateId; // Corresponds to Candidate(id)
    private String degree; // Degree obtained
    private String institution; // College/University name
    private Integer yearOfGraduation; // Year of graduation

    // Getters and Setters
    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(Integer yearOfPassing) {
        this.yearOfGraduation = yearOfPassing;
    }
}