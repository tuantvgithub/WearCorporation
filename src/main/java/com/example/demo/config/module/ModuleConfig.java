package com.example.demo.config.module;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("md-config")
public class ModuleConfig {

    public static final String PRODUCT_MODULE_NAME              = "productTeam";
    public static final String ADVERTISEMENT_MODULE_NAME        = "advertisementTeam";
    public static final String CART_MODULE_NAME                 = "cartTeam";
    public static final String ACCOUNT_MODULE_NAME              = "accountTeam";
    public static final String INVENTORY_MODULE_NAME            = "inventoryTeam";
    public static final String DELIVERY_MODULE_NAME             = "deliveryTeam";
    public static final String SYS_MANAGEMENT_MODULE_NAME       = "sysManagementTeam";
    public static final String CUSTOMER_CARE_MODULE_NAME        = "customerCareTeam";
    public static final String SEARCH_AND_REPORT_MODULE_NAME    = "searchAndReportTeam";
    public static final String ORDER_MODULE_NAME                = "orderTeam";

    private String productTeam;
    private String advertisementTeam;
    private String cartTeam;
    private String accountTeam;
    private String inventoryTeam;
    private String deliveryTeam;
    private String sysManagementTeam;
    private String customerCareTeam;
    private String searchAndReportTeam;
    private String orderTeam;

    public void setTeamForModule(String moduleName, String teamName) {
        if (moduleName.equals(PRODUCT_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(ADVERTISEMENT_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(CART_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(ACCOUNT_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(INVENTORY_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(DELIVERY_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(SYS_MANAGEMENT_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(CUSTOMER_CARE_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(SEARCH_AND_REPORT_MODULE_NAME))
            this.productTeam = teamName;
        if (moduleName.equals(ORDER_MODULE_NAME))
            this.productTeam = teamName;
    }
}
