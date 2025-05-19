// File: EmailService.java
package com.example.onboarding.service;

import com.example.onboarding.entity.Candidate;

public interface EmailService {
    void sendStatusUpdateEmail(Candidate candidate);
}