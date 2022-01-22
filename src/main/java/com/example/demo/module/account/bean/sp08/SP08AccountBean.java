package com.example.demo.module.account.bean.sp08;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP08AccountBean {

    @JsonProperty("_id")
    private String id;

    private String name;

    private String email;

    private String password;

    private String location;
}
