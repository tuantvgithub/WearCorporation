package com.example.demo.client_ui.dto.account;

import lombok.Data;

@Data
public class AccountRegisterFormDTO {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String country;
}
