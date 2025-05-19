package com.example.onboarding.service.impl;

import com.example.onboarding.dto.CandidatePersonalInfoDTO;
import com.example.onboarding.dto.CandidateBankInfoDTO;
import com.example.onboarding.dto.CandidateEducationDTO;
import com.example.onboarding.entity.*;
import com.example.onboarding.repository.*;
import com.example.onboarding.service.CandidateService;
import com.example.onboarding.service.EmailServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidatePersonalInfoRepository personalInfoRepository;
    private final CandidateBankInfoRepository bankInfoRepository;
    private final CandidateEducationInfoRepository educationInfoRepository;
    private final EmailServiceImpl emailService;

    public CandidateServiceImpl(
            CandidateRepository candidateRepository,
            CandidatePersonalInfoRepository personalInfoRepository,
            CandidateBankInfoRepository bankInfoRepository,
            CandidateEducationInfoRepository educationInfoRepository,
            EmailServiceImpl emailService
    ) {
        this.candidateRepository = candidateRepository;
        this.personalInfoRepository = personalInfoRepository;
        this.bankInfoRepository = bankInfoRepository;
        this.educationInfoRepository = educationInfoRepository;
        this.emailService = emailService;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public long getCandidateCount() {
        return candidateRepository.count();
    }

    @Override
    public Candidate updateCandidateStatus(Long id, String status) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setStatus(status);
        Candidate updated = candidateRepository.save(candidate);

        emailService.sendStatusUpdateEmail(candidate);

        return updated;
    }

    @Override
    public List<Candidate> getCandidatesByStatus(String status) {
        return candidateRepository.findByStatusIgnoreCase(status);
    }

    @Override
    public void updateCandidatePersonalInfo(Long candidateId, CandidatePersonalInfoDTO dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        CandidatePersonalInfo info = new CandidatePersonalInfo();
        info.setCandidate(candidate);
        info.setDob(dto.getDob());
        info.setGender(dto.getGender());
        info.setAddress(dto.getAddress());
        info.setNationality(dto.getNationality());

        personalInfoRepository.save(info);
    }

    @Override
    public void updateCandidateBankInfo(Long candidateId, CandidateBankInfoDTO dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        CandidateBankInfo info = new CandidateBankInfo();
        info.setCandidate(candidate);
        info.setBankName(dto.getBankName());
        info.setAccountNumber(dto.getAccountNumber());
        info.setIfscCode(dto.getIfscCode());

        bankInfoRepository.save(info);
    }

    @Override
    public void updateCandidateEducationInfo(Long candidateId, CandidateEducationDTO dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        CandidateEducationInfo info = new CandidateEducationInfo();
        info.setCandidate(candidate);
        info.setDegree(dto.getDegree());
        info.setInstitution(dto.getInstitution());
        info.setYearOfGraduation(dto.getYearOfGraduation());

        educationInfoRepository.save(info);
    }
}
