package com.example.demo.client_ui.controller;

import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.service.SystemManagementService;
import com.example.demo.switch_team.service.SwitchTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/module")
public class ModuleConfigController {

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private SwitchTeamService switchTeamService;

    private final Map<String, SystemManagementService> sysManagementServiceMap;

    @Autowired
    private ModuleConfigController(Map<String, SystemManagementService> sysManagementServiceMap) {
        this.sysManagementServiceMap = sysManagementServiceMap;
    }

    @GetMapping
    public String getModuleConfigPage(Model model) {
        SystemManagementService systemManagementService =
                this.sysManagementServiceMap.get(this.moduleConfig.getSysManagementTeam());

        return "module-config";
    }

    @GetMapping("/submit")
    public String submitModuleConfig(
            Model model,
            @RequestParam(value = "product-team", required = false) String productTeam,
            @RequestParam(value = "order-team", required = false) String orderTeam,
            @RequestParam(value = "account-team", required = false) String accountTeam,
            @RequestParam(value = "delivery-team", required = false) String deliveryTeam,
            @RequestParam(value = "customer-care-team", required = false) String customerCareTeam
    ) {
        SystemManagementService systemManagementService =
                this.sysManagementServiceMap.get(this.moduleConfig.getSysManagementTeam());

        if (productTeam != null)
            systemManagementService.setModule(ModuleCode.PRODUCT_MODULE, productTeam);
        if (orderTeam != null)
            systemManagementService.setModule(ModuleCode.ORDER_MODULE, orderTeam);
        if (accountTeam != null)
            systemManagementService.setModule(ModuleCode.ACCOUNT_MODULE, accountTeam);
        if (deliveryTeam != null)
            systemManagementService.setModule(ModuleCode.DELIVERY_MODULE, deliveryTeam);
        if (customerCareTeam != null)
            systemManagementService.setModule(ModuleCode.CUSTOMER_CARE_MODULE, customerCareTeam);

        return "redirect:/module";
    }

    @GetMapping("/reload")
    public String reloadModule(Model model) {
        SystemManagementService systemManagementService =
                this.sysManagementServiceMap.get(this.moduleConfig.getSysManagementTeam());

        systemManagementService.loadModules();

        model.addAttribute("notice", "Reload --> OK");

        return "redirect:/module";
    }
}
