package com.example.onboarding.repository;

import com.example.onboarding.entity.JobOfferNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferNotificationRepository extends JpaRepository<JobOfferNotification, Long> {
}