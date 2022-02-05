package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackFormDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class IntroductionController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, CustomerCareService> customerCareServiceMap;

    @Autowired
    private IntroductionController(Map<String, CustomerCareService> customerCareServiceMap) {
        this.customerCareServiceMap = customerCareServiceMap;
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        FeedbackFormDTO feedbackFormDTO = new FeedbackFormDTO();
        feedbackFormDTO.setUserId(this.currentAccount.getId());

        model.addAttribute("feedbackForm", feedbackFormDTO);

        return "contact";
    }

    @PostMapping("/contact/submit")
    public String submitFeedback(@ModelAttribute("feedbackForm") FeedbackFormDTO feedbackFormDTO,
                                 Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        this.customerCareServiceMap.get(this.moduleConfig.getCustomerCareTeam())
                .sendFeedbackForm(feedbackFormDTO);

        return "redirect:/feedback-successful";
    }

    @GetMapping("/faq")
    public String getFAQPage(Model model) {
        return "faq";
    }
}
