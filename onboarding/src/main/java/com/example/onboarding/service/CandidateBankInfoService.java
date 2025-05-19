package com.example.onboarding.service;

import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.CandidateBankInfo;
import com.example.onboarding.repository.CandidateBankInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateBankInfoService {

    private final CandidateBankInfoRepository bankInfoRepository;

    @Autowired
    public CandidateBankInfoService(CandidateBankInfoRepository bankInfoRepository) {
        this.bankInfoRepository = bankInfoRepository;
    }

    public CandidateBankInfo updateBankInfo(Long candidateId, CandidateBankInfo bankInfo) {
        // Link the bank info to the candidate
        bankInfo.setCandidate(new Candidate(candidateId));
        return bankInfoRepository.save(bankInfo);
    }
}