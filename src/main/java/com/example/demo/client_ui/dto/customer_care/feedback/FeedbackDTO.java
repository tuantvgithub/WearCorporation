package com.example.demo.client_ui.dto.customer_care.feedback;

import lombok.Data;

@Data
public class FeedbackDTO {

    private Integer feedbackId;

    private Integer userId;

    private String subject;

    private String message;
}
