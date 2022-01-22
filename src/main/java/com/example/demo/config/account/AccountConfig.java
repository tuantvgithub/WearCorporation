package com.example.demo.config.account;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public CurrentAccount currentAccount() {
        CurrentAccount acc = new CurrentAccount();

        acc.setRole(AccountRoleDTO.GUEST_ROLE);
        acc.setAdmin(false);

        return acc;
    }
}
