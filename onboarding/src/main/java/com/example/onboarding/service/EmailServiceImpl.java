// File: EmailServiceImpl.java
package com.example.onboarding.service;

import com.example.onboarding.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendStatusUpdateEmail(Candidate candidate) {
        String subject = "Update on Your Application Status";
        String message = "Dear " + candidate.getName() + ",\n\n"
                + "Your application status has been updated to: " + candidate.getStatus() + ".\n\n"
                + "Regards,\nOnboarding Team";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(candidate.getEmail());
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        try {
            mailSender.send(mailMessage);
            System.out.println("Email sent to " + candidate.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to send email to " + candidate.getEmail());
            e.printStackTrace();
        }
    }

}