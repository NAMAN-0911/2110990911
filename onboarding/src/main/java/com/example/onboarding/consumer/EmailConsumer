package com.example.onboarding.consumer;

import com.example.onboarding.dto.EmailMessage;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.JobOfferNotification;
import com.example.onboarding.repository.CandidateRepository;
import com.example.onboarding.repository.JobOfferNotificationRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;

@Component
public class EmailConsumer {

    private final JavaMailSender mailSender;
    private final CandidateRepository candidateRepository;
    private final JobOfferNotificationRepository notificationRepository;

    public EmailConsumer(JavaMailSender mailSender,
                         CandidateRepository candidateRepository,
                         JobOfferNotificationRepository notificationRepository) {
        this.mailSender = mailSender;
        this.candidateRepository = candidateRepository;
        this.notificationRepository = notificationRepository;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeEmailMessage(EmailMessage message) {
        JobOfferNotification notification = new JobOfferNotification();
        Candidate candidate = candidateRepository
                .findById(message.getCandidateId())
                .orElse(null);

        if (candidate != null) {
            notification.setCandidate(candidate);
        }

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // true = multipart

            helper.setTo(message.getTo());
            helper.setSubject(message.getSubject());

            String htmlBody = "<h2>Dear " + candidate.getName() + ",</h2>" +
                    "<p>Congratulations! You are selected for the position of <b>" + candidate.getPosition() + "</b>.</p>" +
                    "<p>We are excited to have you onboard.</p><br>" +
                    "<p>Regards,<br>HR Team</p>";

            helper.setText(htmlBody, true); // true = HTML

            // Optional: Add attachment if needed
            // FileSystemResource file = new FileSystemResource(new File("/path/to/offer-letter.pdf"));
            // helper.addAttachment("OfferLetter.pdf", file);

            mailSender.send(mimeMessage);

            notification.setSent(true);
            notification.setSentAt(LocalDateTime.now());

        } catch (Exception e) {
            notification.setSent(false);
            notification.setRetryCount(notification.getRetryCount() + 1);
            notification.setErrorMessage(e.getMessage());
        }

        notificationRepository.save(notification);
    }
}
