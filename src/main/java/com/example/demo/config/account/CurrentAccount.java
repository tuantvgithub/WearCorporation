package com.example.demo.config.account;


import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import lombok.Data;

@Data
public class CurrentAccount {

    private Integer id;

    private String email;

    private AccountRoleDTO role;

    private boolean isAdmin;

    private String fullname;

    private String country;

    private String phone;

    private String birthday;

}
