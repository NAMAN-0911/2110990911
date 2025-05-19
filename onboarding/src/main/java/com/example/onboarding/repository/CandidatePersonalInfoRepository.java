package com.example.onboarding.repository;

import com.example.onboarding.entity.CandidatePersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatePersonalInfoRepository extends JpaRepository<CandidatePersonalInfo, Long> {
    // You can add custom queries here if needed
}