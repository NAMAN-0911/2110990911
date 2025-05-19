package com.example.onboarding.controller;

import com.example.onboarding.entity.CandidatePersonalInfo;
import com.example.onboarding.service.CandidatePersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/{id}")
public class CandidatePersonalInfoController {

    private final CandidatePersonalInfoService personalInfoService;

    @Autowired
    public CandidatePersonalInfoController(CandidatePersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @PutMapping("/personal-info")
    public CandidatePersonalInfo updatePersonalInfo(@PathVariable Long id, @RequestBody CandidatePersonalInfo personalInfo) {
        return personalInfoService.updatePersonalInfo(id, personalInfo);
    }
}