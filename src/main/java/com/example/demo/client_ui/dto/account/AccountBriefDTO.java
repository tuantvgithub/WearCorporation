package com.example.demo.client_ui.dto.account;

import lombok.Data;

@Data
public class AccountBriefDTO {

    private String id;

    private String email;

    private AccountRoleDTO role;
}
