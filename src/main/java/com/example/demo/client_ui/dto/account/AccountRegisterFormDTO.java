package com.example.demo.client_ui.dto.account;

import lombok.Data;

@Data
public class AccountRegisterFormDTO {

    private String username;

    private String email;

    private String password;

    private String password_confirmation;

    private String firstName;

    private String lastName;

    private String phone;
    
    private String country;
}
