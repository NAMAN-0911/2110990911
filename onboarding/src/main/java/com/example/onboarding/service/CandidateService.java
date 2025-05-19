package com.example.onboarding.service;

import com.example.onboarding.dto.CandidatePersonalInfoDTO;
import com.example.onboarding.dto.CandidateBankInfoDTO;
import com.example.onboarding.dto.CandidateEducationDTO;
import com.example.onboarding.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> getAllCandidates();
    Optional<Candidate> getCandidateById(Long id);
    long getCandidateCount();
    Candidate updateCandidateStatus(Long id, String status);
    List<Candidate> getCandidatesByStatus(String status);

    void updateCandidatePersonalInfo(Long candidateId, CandidatePersonalInfoDTO personalInfoDTO);
    void updateCandidateBankInfo(Long candidateId, CandidateBankInfoDTO bankInfoDTO);
    void updateCandidateEducationInfo(Long candidateId, CandidateEducationDTO educationInfoDTO);
}