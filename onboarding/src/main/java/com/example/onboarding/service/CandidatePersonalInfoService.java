package com.example.onboarding.service;

import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.CandidatePersonalInfo;
import com.example.onboarding.repository.CandidatePersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatePersonalInfoService {

    private final CandidatePersonalInfoRepository personalInfoRepository;

    @Autowired
    public CandidatePersonalInfoService(CandidatePersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    public CandidatePersonalInfo updatePersonalInfo(Long candidateId, CandidatePersonalInfo personalInfo) {
        // Find existing candidate info and update
        personalInfo.setCandidate(new Candidate(candidateId));  // Link the info to the candidate
        return personalInfoRepository.save(personalInfo);
    }
}