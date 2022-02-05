package com.example.demo.client_ui.dto.customer_care.feedback;

import lombok.Data;

@Data
public class FeedbackFormDTO {

    private Integer userId;

    private String userName;

    private String userEmail;

    private String subject;

    private String message;
}
