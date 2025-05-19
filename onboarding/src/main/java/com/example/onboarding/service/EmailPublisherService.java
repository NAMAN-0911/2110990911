// File: EmailPublisherService.java
package com.example.onboarding.service;

import com.example.onboarding.dto.EmailMessage;
import com.example.onboarding.entity.Candidate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailPublisherService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public EmailPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStatusUpdateEmail(Candidate candidate) {
        String subject = "Update on Your Application Status";
        String message = "Dear " + candidate.getName() + ",\n\n"
                + "Your application status has been updated to: " + candidate.getStatus() + ".\n\n"
                + "Regards,\nOnboarding Team";

        EmailMessage emailMessage = new EmailMessage(candidate.getId(),candidate.getEmail(), subject, message);
        rabbitTemplate.convertAndSend(exchange, routingKey, emailMessage);
    }
}