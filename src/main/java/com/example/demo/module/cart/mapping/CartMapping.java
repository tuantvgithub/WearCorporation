package com.example.demo.module.cart.mapping;

import java.util.List;

import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.bean.sp12.SP12ProductCartBean;

public interface CartMapping {

    ProductCartDTO mapSP12BeanToDto(SP12ProductCartBean sp12ProductCartBean);

    SP12ProductCartBean mapDtoToSp12Bean(ProductCartDTO productCartDTO);

    List<ProductCartDTO> mapListSP12BeanToListDTO(List<SP12ProductCartBean> listProduct);
}
