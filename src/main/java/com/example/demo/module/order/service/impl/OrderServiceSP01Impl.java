package com.example.demo.module.order.service.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.order.bean.sp01.SP01OrderBean;
import com.example.demo.module.order.bean.sp01.SP01ProductOrderBean;
import com.example.demo.module.order.mapping.OrderMapping;
import com.example.demo.module.order.proxies.OrderSP01WebServiceProxy;
import com.example.demo.module.order.service.OrderService;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("sp01-order")
public class OrderServiceSP01Impl implements OrderService {

    public static final String X_API_KEY_TOKEN = "kappa123";

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private Map<String, ProductService> productServiceMap;

    @Autowired
    private OrderSP01WebServiceProxy orderSP01WebServiceProxy;

    @Autowired
    private OrderMapping orderMapping;

    @Override
    public List<OrderBriefDTO> getAllOrderDTOByUserId(Long userId) {
        List<SP01OrderBean> sp01OrderBeanList =
                this.orderSP01WebServiceProxy.getAllOrder(X_API_KEY_TOKEN, null);
        if (sp01OrderBeanList == null) return null;
        List<OrderBriefDTO> briefDTOList = new LinkedList<>();

        for (SP01OrderBean orderBean : sp01OrderBeanList)
            if (orderBean.getUserId().equals(userId))
                briefDTOList.add(this.orderMapping.beanToBriefDTO(orderBean));

        return briefDTOList;
    }

    @Override
    public OrderDetailDTO getOrderDTOById(Long orderId) {
        ProductService productService =
                this.productServiceMap.get(this.moduleConfig.getProductTeam());
        SP01OrderBean orderBean =
                this.orderSP01WebServiceProxy.getOrderById(X_API_KEY_TOKEN, orderId);
        OrderDetailDTO detailDTO = this.orderMapping.beanToDetailDTO(orderBean);

        if (detailDTO == null) return null;
        List<ProductOrderDTO> productOrderDTOList = new LinkedList<>();
        if (orderBean.getProductOrderList() != null) {
            for (SP01ProductOrderBean sp01ProductOrderBean : orderBean.getProductOrderList()) {
                ProductDetailDTO productDetailDTO =
                        productService.getProductDetailDTOById(sp01ProductOrderBean.getProductId());
                if (productDetailDTO == null) continue;
                ProductOrderDTO productOrderDTO = new ProductOrderDTO();
                productOrderDTO.setProductId(productDetailDTO.getId());
                productOrderDTO.setProductPrice(productDetailDTO.getPrice());
                productOrderDTO.setProductName(productDetailDTO.getName());
                productOrderDTO.setProductImageUrl(productDetailDTO.getImageUrl());
                productOrderDTO.setQuantity(sp01ProductOrderBean.getQuantity());

                productOrderDTOList.add(productOrderDTO);
            }
        }
        detailDTO.setProductList(productOrderDTOList);

        return detailDTO;
    }
}
