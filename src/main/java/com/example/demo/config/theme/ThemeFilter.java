package com.example.demo.config.theme;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ThemeFilter extends OncePerRequestFilter {

    @Autowired
    private Map<String, SystemManagementService> sysManagementServiceMap;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private CurrentTheme currentTheme;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        SystemManagementService systemManagementService = sysManagementServiceMap
                .get(moduleConfig.getSysManagementTeam());
        if (currentAccount.getId() != null) {
            ThemeRequest themeRequest = new ThemeRequest();
            themeRequest.setUserId(this.currentAccount.getId());
            ThemeDTO themeDTO = systemManagementService.getTheme(themeRequest);
            currentTheme.setFontSize(themeDTO.getFontSize());
            currentTheme.setLanguage(themeDTO.getLanguage());
            currentTheme.setTheme(themeDTO.getTheme());
            currentTheme.setUserId(themeDTO.getUserId());

        }
        filterChain.doFilter(request, response);

    }

}
