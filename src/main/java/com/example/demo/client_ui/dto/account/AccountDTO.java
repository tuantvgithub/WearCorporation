package com.example.demo.client_ui.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String country;

    private String phone;

    private String avatarImageUrl;

    private String dateOfBirth;
}
