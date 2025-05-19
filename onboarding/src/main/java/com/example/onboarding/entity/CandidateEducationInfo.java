package com.example.onboarding.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidate_education_info")
public class CandidateEducationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    private String degree; // Degree obtained
    private String institution; // College/University name
    private Integer yearOfGraduation; // Year of graduation

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Candidate getCandidate() { return candidate; }
    public void setCandidate(Candidate candidate) { this.candidate = candidate; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public Integer getYearOfGraduation() { return yearOfGraduation; }
    public void setYearOfGraduation(Integer yearOfGraduation) { this.yearOfGraduation = yearOfGraduation; }
}