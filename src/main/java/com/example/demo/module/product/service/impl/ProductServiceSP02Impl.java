package com.example.demo.module.product.service.impl;

import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.module.product.mapping.ProductMapping;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service("sp02-product")
public class ProductServiceSP02Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    private final String PRODUCT_DESCRIPTION = "Lorem ipsum dolor sit amet, " +
            "consectetur adipisicing elit." +
            " Laborum ipsum dicta quod, quia doloremque aut deserunt commodi quis. " +
            "Totam a consequatur beatae nostrum, earum consequuntur? " +
            "Eveniet consequatur ipsum dicta recusandae.\n" + "\n" +
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
            "Nesciunt, velit, sunt temporibus, nulla accusamus similique" +
            " sapiente tempora, at atque cumque assumenda minus asperiores " +
            "est esse sequi dolore magnam. Debitis, explicabo.";

    private final List<ProductDetailDTO> PRODUCT_LIST = Arrays.asList(
            new ProductDetailDTO(1, "Reef Boardsport", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-1.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(2, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-2.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(3, "Stray horn SP", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-3.jpg", null,
                    true, "E-SHOPPER", 80, 3),
            new ProductDetailDTO(4, "Bradley Mid", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-4.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(5, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-5.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(6, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-6.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(7, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-7.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(8, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-8.jpg", null,
                    true, "E-SHOPPER", 200, 3),
            new ProductDetailDTO(9, "Rainbow Shoes", this.PRODUCT_DESCRIPTION,
                    "/images/shop/products/product-9.jpg", null,
                    true, "E-SHOPPER", 200, 3));

    @Override
    public ProductDetailDTO getProductDetailDTOById(Integer productId) {
        for (ProductDetailDTO detailDTO : this.PRODUCT_LIST)
            if (detailDTO.getId().equals(productId))
                return detailDTO;

        return null;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();
        for (ProductDetailDTO detailDTO : this.PRODUCT_LIST) {
            ProductBriefDTO briefDTO = this.productMapping.detailDTOToBriefDTO(detailDTO);
            if (briefDTO != null) briefDTOList.add(briefDTO);
        }
        return briefDTOList;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }

    @Override
    public List<ProductBriefDTO> getProductByFilter(HashMap<String, Object> params) {
        return getAllProductBriefDTO();
    }
}
