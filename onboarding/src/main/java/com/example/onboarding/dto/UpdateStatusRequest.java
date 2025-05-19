// UpdateStatusRequest.java
package com.example.onboarding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdateStatusRequest {

    @NotBlank(message = "Status cannot be blank")
    @Pattern(
            regexp = "Offer Sent|Onboarded|Rejected",
            message = "Status must be one of: Offer Sent, Onboarded, Rejected"
    )
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}