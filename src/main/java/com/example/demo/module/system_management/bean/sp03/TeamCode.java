package com.example.demo.module.system_management.bean.sp03;

public enum TeamCode {
    SP11("SP_11"), SP17("SP_17"),
    SP07("SP_07"), SP15("SP_15"),
    SP06("SP_06"), SP21("SP_21"),
    SP08("SP_08"), SP14("SP_14"),
    SP01("SP_01"), SP16("SP_16"),
    SP02("SP_02");

    private final String value;

    TeamCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
