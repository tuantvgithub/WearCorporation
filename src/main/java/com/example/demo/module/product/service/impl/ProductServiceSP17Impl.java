package com.example.demo.module.product.service.impl;

import com.example.demo.module.product.bean.sp17.SP17CategoryDetailBean;
import com.example.demo.module.product.bean.sp17.SP17ProductDetailBean;
import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.module.product.mapping.ProductMapping;
import com.example.demo.module.product.proxies.ProductSP17WebServiceProxy;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service("sp17-product")
public class ProductServiceSP17Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    ProductSP17WebServiceProxy webServiceProxy;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Integer productId) {
        List<SP17ProductDetailBean> detailBean = this.webServiceProxy.getProductById(productId);
        if (detailBean == null || detailBean.isEmpty()) return null;

        ProductDetailDTO detailDTO = this.productMapping.detailBeanToDetailDTO(detailBean.get(0));
        if (detailDTO == null) return null;
        List<SP17CategoryDetailBean> categoryDetailBean =
                this.webServiceProxy.getCategoryById(detailBean.get(0).getCategoryId());

        detailDTO.setCategoryDTO(this.productMapping.categoryDetailBeanToCategoryDTO(categoryDetailBean.get(0)));

        return detailDTO;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        List<SP17ProductDetailBean> detailBeanList = this.webServiceProxy.getAllProduct();
        if (detailBeanList == null) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();
        for (SP17ProductDetailBean detailBean : detailBeanList)
            briefDTOList.add(this.productMapping.detailBeanToBriefDTO(detailBean));

        return briefDTOList;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<SP17CategoryDetailBean> detailBeanList = this.webServiceProxy.getAllCategories();
        if (detailBeanList == null || detailBeanList.isEmpty()) return null;
        List<CategoryDTO> dtoList = new LinkedList<>();

        for (SP17CategoryDetailBean bean : detailBeanList) {
            CategoryDTO dto = this.productMapping.categoryDetailBeanToCategoryDTO(bean);
            if (dto != null) dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<ProductBriefDTO> getProductByFilter(HashMap<String, Object> params) {
        if (params == null || params.isEmpty())
            return this.getAllProductBriefDTO();

        List<SP17ProductDetailBean> detailBeanList = this.webServiceProxy
                .getAllProduct((Integer) params.get("category_id"), null, null);

        if (detailBeanList == null || detailBeanList.isEmpty()) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();

        for (SP17ProductDetailBean bean : detailBeanList) {
            ProductBriefDTO dto = this.productMapping.detailBeanToBriefDTO(bean);
            if (dto != null) briefDTOList.add(dto);
        }

        return briefDTOList;
    }
}
