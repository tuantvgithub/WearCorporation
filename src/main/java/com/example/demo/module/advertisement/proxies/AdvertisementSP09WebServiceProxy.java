package com.example.demo.module.advertisement.proxies;

import com.example.demo.module.advertisement.bean.sp09.SP09ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "sp09-adv-api", url = "https://ltct-api.2soft.top")
public interface AdvertisementSP09WebServiceProxy {

    @GetMapping("/advertisements")
    SP09ResponseBean<List<HashMap<String, Object>>> getAllAdvertisements();
}
