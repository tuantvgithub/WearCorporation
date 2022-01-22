package com.example.demo.switch_team.service.impl;

import com.example.demo.config.module.ModuleConfig;
import com.example.demo.switch_team.service.SwitchTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SwitchTeamServiceImpl implements SwitchTeamService {

    public static final List<String> AVAILABLE_PRODUCT_TEAM = Arrays.asList("sp02-product", "sp17-product", "sp11-product");
    public static final List<String> AVAILABLE_ORDER_TEAM = Arrays.asList("sp02-order", "sp01-order");
    public static final List<String> AVAILABLE_INVENTORY_TEAM = Arrays.asList("sp02-inventory");
    public static final List<String> AVAILABLE_ACCOUNT_TEAM = Arrays.asList("sp02-account");
    public static final List<String> AVAILABLE_CUSTOMER_CARE_TEAM = Arrays.asList("sp02-customer-care", "sp21-customer-care");
    public static final List<String> AVAILABLE_DELIVERY_TEAM = Arrays.asList("sp02-delivery");
    public static final List<String> AVAILABLE_ADVERTISEMENT_TEAM = Arrays.asList("sp02-advertisement", "sp09-advertisement");
    public static final List<String> AVAILABLE_CART_TEAM = Arrays.asList("sp02-cart","sp12-cart");
    public static final List<String> AVAILABLE_SYS_MANAGEMENT_TEAM = Arrays.asList("sp02-sys-management", "sp03-sys-management");
    public static final List<String> AVAILABLE_SEARCH_AND_REPORT_TEAM = Arrays.asList("sp02-search-and-report");

    public static final String MODULE_IS_NOT_AVAILABLE_MESSAGE = "Module bạn yêu cầu chưa sử dụng được";
    public static final String SWITCH_SUCCESS_MESSAGE = "Đã chuyển module thành công";

    @Autowired
    private ModuleConfig moduleConfig;

    /**
     *
     * @param productTeam - must not be null
     */
    @Override
    public String switchProductTeam(String productTeam) {
        if (!AVAILABLE_PRODUCT_TEAM.contains(productTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setProductTeam(productTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchAccountTeam(String accountTeam) {
        if (!AVAILABLE_ACCOUNT_TEAM.contains(accountTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setAccountTeam(accountTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchCartTeam(String cartTeam) {
        if (!AVAILABLE_CART_TEAM.contains(cartTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setCartTeam(cartTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchAdvertisementTeam(String advertisementTeam) {
        if (!AVAILABLE_ADVERTISEMENT_TEAM.contains(advertisementTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setAdvertisementTeam(advertisementTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchCustomerCareTeam(String customerCareTeam) {
        if (!AVAILABLE_CUSTOMER_CARE_TEAM.contains(customerCareTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setCustomerCareTeam(customerCareTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchInventoryTeam(String inventoryTeam) {
        if (!AVAILABLE_INVENTORY_TEAM.contains(inventoryTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setInventoryTeam(inventoryTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchDeliveryTeam(String deliveryTeam) {
        if (!AVAILABLE_DELIVERY_TEAM.contains(deliveryTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setDeliveryTeam(deliveryTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchOrderTeam(String orderTeam) {
        if (!AVAILABLE_ORDER_TEAM.contains(orderTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setOrderTeam(orderTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchSystemManagementTeam(String systemManagementTeam) {
        if (!AVAILABLE_SYS_MANAGEMENT_TEAM.contains(systemManagementTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setSysManagementTeam(systemManagementTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }

    @Override
    public String switchSearchAndReportTeam(String searchAndReportTeam) {
        if (!AVAILABLE_SEARCH_AND_REPORT_TEAM.contains(searchAndReportTeam))
            return MODULE_IS_NOT_AVAILABLE_MESSAGE;

        this.moduleConfig.setSearchAndReportTeam(searchAndReportTeam);
        return SWITCH_SUCCESS_MESSAGE;
    }
}
