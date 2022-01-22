package com.example.demo.module.account.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sp08-api", url = "https://ltct-api.herokuapp.com/api/ltct")
public interface AccountSP08WebServiceProxy {

}
