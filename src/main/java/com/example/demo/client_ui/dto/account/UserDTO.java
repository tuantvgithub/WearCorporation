package com.example.demo.client_ui.dto.account;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String country;

    private String email;

    private String phone;

    private String avatarImageUrl;
}
