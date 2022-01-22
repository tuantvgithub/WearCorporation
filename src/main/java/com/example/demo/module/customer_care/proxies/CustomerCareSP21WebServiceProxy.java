package com.example.demo.module.customer_care.proxies;

import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "sp21-api", url = "http://it4492sp21.herokuapp.com")
public interface CustomerCareSP21WebServiceProxy {

    @GetMapping("/product/{id}/comment")
    List<SP21ProductCommentBean> getAllCommentByProductId(@PathVariable("id") Integer productId);
}
