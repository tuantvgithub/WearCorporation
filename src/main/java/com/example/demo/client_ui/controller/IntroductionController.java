package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroductionController {

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        return "about";
    }

    @GetMapping("/faq")
    public String getFAQPage(Model model) {
        return "faq";
    }
}
