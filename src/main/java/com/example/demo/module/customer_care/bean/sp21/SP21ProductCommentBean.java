package com.example.demo.module.customer_care.bean.sp21;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP21ProductCommentBean {

    private Integer id;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("user_id")
    private Integer userId;

    private String comment;

    private String photo;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;
}
