package com.example.demo.module.order.bean;

import lombok.Data;

@Data
public class ResponseOrder<T> {
    
    private T data;
}
