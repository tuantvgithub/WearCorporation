package com.example.demo.module.account.bean.sp08;

import lombok.Data;

@Data
public class SP08ResponseBean<T> {

    private Long status;

    private T data;

    private String msg;
}
