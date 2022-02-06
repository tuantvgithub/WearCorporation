package com.example.demo.module.sale_promotion.bean.sp19;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP19CodeResponseBean {

    @JsonProperty("data")
    private List<CodeSP19Bean> data;
}
