package com.example.demo.config.theme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThemeConfig {
    @Bean
    public CurrentTheme getCurrentTheme()
    {
        return new CurrentTheme();
    }
}
