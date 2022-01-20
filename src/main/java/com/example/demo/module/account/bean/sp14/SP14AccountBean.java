package com.example.demo.module.account.bean.sp14;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP14AccountBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    @JsonProperty("updated_at")
    private Date updated_at;

    @JsonProperty("created_at")
    private Date created_at;

    @JsonProperty("role")
    private String role;

    @JsonProperty("address")
    private String address;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("phone")
    private String phone;

    

}
