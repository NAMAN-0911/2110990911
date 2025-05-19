package com.example.onboarding.service;

import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.CandidateEducationInfo;
import com.example.onboarding.repository.CandidateEducationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateEducationInfoService {

    private final CandidateEducationInfoRepository educationInfoRepository;

    @Autowired
    public CandidateEducationInfoService(CandidateEducationInfoRepository educationInfoRepository) {
        this.educationInfoRepository = educationInfoRepository;
    }

    public CandidateEducationInfo updateEducationInfo(Long candidateId, CandidateEducationInfo educationInfo) {
        // Link the education info to the candidate
        educationInfo.setCandidate(new Candidate(candidateId));
        return educationInfoRepository.save(educationInfo);
    }
}