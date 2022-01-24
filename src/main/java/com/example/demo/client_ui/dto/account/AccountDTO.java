package com.example.demo.client_ui.dto.account;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private String password_confirmation;

    private String firstName;

    private String lastName;

    private String country;

    private String phone;

    private String avatarImageUrl;

    private String dateOfBirth;
    
    private String invalidPassword;

    private String invalidUsername;

    private String invalidEmail;

    private String invalidPhone;

}
