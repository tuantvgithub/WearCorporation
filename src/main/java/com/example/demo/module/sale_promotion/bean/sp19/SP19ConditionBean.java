package com.example.demo.module.sale_promotion.bean.sp19;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SP19ConditionBean {
    
    @JsonProperty("conditionType")
    private Integer type;

    @JsonProperty("conditionValue")
    private Integer condition;
}
