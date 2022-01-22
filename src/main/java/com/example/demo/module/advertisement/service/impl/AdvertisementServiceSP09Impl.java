package com.example.demo.module.advertisement.service.impl;

import com.example.demo.module.advertisement.bean.sp09.SP09ResponseBean;
import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.module.advertisement.mapping.AdvertisementMapping;
import com.example.demo.module.advertisement.proxies.AdvertisementSP09WebServiceProxy;
import com.example.demo.module.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("sp09-advertisement")
public class AdvertisementServiceSP09Impl implements AdvertisementService {

    @Autowired
    private AdvertisementSP09WebServiceProxy webServiceProxy;

    @Autowired
    private AdvertisementMapping advertisementMapping;

    @Override
    public List<AdvertisementBriefDTO> getAllAdvertisementBriefDTOs() {
        SP09ResponseBean<List<HashMap<String, Object>>> response =
                this.webServiceProxy.getAllAdvertisements();

        return response.getStatusCode() == 200 ?
                this.advertisementMapping.beansToBriefDTOs(response.getData()) : null;
    }
}
