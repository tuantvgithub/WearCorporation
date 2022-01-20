package com.example.demo.client_ui.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    @JsonProperty("userId")
    private Integer userId;
}
