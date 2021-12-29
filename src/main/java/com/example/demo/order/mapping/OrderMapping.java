package com.example.demo.order.mapping;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.order.bean.sp01.SP01OrderBean;

public interface OrderMapping {

    OrderBriefDTO beanToBriefDTO(SP01OrderBean bean);

    OrderDetailDTO beanToDetailDTO(SP01OrderBean bean);
}
