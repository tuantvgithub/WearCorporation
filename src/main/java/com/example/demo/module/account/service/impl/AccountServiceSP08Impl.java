package com.example.demo.module.account.service.impl;

import com.example.demo.client_ui.dto.account.AccountDTO;
import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;
import com.example.demo.module.account.service.AccountService;
import org.springframework.stereotype.Service;

@Service("sp08-account")
public class AccountServiceSP08Impl implements AccountService {

    @Override
    public AccountDTO login(AccountLoginFormDTO formDTO) {
        return null;
    }

    @Override
    public AccountDTO signup(AccountRegisterFormDTO formDTO) {
        return null;
    }
}
