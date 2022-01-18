package com.example.demo.module.account.service.impl;

import com.example.demo.client_ui.dto.account.AccountDTO;
import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;
import com.example.demo.module.account.bean.AccountResponseBean;
import com.example.demo.module.account.bean.sp14.SP14AccountBean;
import com.example.demo.module.account.proxies.AccountSP14WebServiceProxy;
import com.example.demo.module.account.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("sp14-account")
@Slf4j
public class AccountServiceSP14Impl implements AccountService {

    @Autowired
    private AccountSP14WebServiceProxy accountSP14WebServiceProxy;

    @Override
    public AccountDTO login(AccountLoginFormDTO formDTO) {
        try {
            AccountResponseBean<SP14AccountBean> responseBean = accountSP14WebServiceProxy.login(formDTO);
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(responseBean.getData().getId());
            accountDTO.setEmail(responseBean.getData().getEmail());
            accountDTO.setUsername(responseBean.getData().getUsername());
            return accountDTO;
        } catch (Exception excpt) {
            log.error(excpt.getMessage(), excpt.getCause());
            return null;
        }
    }

    @Override
    public AccountDTO signup(AccountRegisterFormDTO formDTO) {
        try {
            AccountResponseBean<SP14AccountBean> responseBean = accountSP14WebServiceProxy.signup(formDTO);

            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(responseBean.getData().getId());
            accountDTO.setEmail(responseBean.getData().getEmail());
            accountDTO.setUsername(responseBean.getData().getUsername());
            return accountDTO;
        } catch (Exception excpt) {
            log.error(excpt.getMessage(), excpt.getCause());
            return null;
        }
    }
}
