package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public static final String ADMIN_DASHBOARD_URL = "https://ltct-p04.herokuapp.com/#/report/advertisment";

    @GetMapping("/dashboard")
    public ModelAndView getDashboard() {
        return new ModelAndView("redirect:" + ADMIN_DASHBOARD_URL);
    }
}
