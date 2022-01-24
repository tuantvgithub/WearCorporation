package com.example.demo.module.system_management.bean.sp03;

public enum ModuleCode {

    PRODUCT_MODULE(0),
    DELIVERY_MODULE(1),
    CUSTOMER_CARE_MODULE(2),
    ACCOUNT_MODULE(4),
    ORDER_MODULE(9);

    private final int value;

    ModuleCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
