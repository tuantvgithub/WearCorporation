package com.example.demo.module.customer_care.bean.sp21;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP21FeedBackBean {

    @JsonProperty("id")
    private  Integer id;

    @JsonProperty("user_id")
    private  Integer userId;

    @JsonProperty("content")
    private  String content;
}
