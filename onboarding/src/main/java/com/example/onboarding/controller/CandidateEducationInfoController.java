package com.example.onboarding.controller;

import com.example.onboarding.entity.CandidateEducationInfo;
import com.example.onboarding.service.CandidateEducationInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/{id}")
public class CandidateEducationInfoController {

    private final CandidateEducationInfoService educationInfoService;

    @Autowired
    public CandidateEducationInfoController(CandidateEducationInfoService educationInfoService) {
        this.educationInfoService = educationInfoService;
    }

    @PutMapping("/educational-info")
    public CandidateEducationInfo updateEducationInfo(@PathVariable Long id, @RequestBody CandidateEducationInfo educationInfo) {
        return educationInfoService.updateEducationInfo(id, educationInfo);
    }
}