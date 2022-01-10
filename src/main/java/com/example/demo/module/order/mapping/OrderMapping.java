package com.example.demo.module.order.mapping;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.module.order.bean.sp01.SP01OrderBean;

public interface OrderMapping {

    OrderBriefDTO beanToBriefDTO(SP01OrderBean bean);

    OrderDetailDTO beanToDetailDTO(SP01OrderBean bean);
}
