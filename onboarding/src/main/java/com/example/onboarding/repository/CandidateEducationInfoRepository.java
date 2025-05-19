package com.example.onboarding.repository;

import com.example.onboarding.entity.CandidateEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEducationInfoRepository extends JpaRepository<CandidateEducationInfo, Long> {
    // Custom queries can be added here if needed
}