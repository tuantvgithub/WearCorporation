package com.example.demo.client_ui.dto.account;

public enum AccountRoleDTO {

    BUYER(0),
    SALESMAN(1),
    IT_TECHNICIAN(2),
    SHIPPING_MANAGER(3),
    GUEST_ROLE(10);

    private final int value;
    private AccountRoleDTO(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
