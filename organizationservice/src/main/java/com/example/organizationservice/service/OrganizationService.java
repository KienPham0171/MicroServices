package com.example.organizationservice.service;

import com.example.organizationservice.events.source.SimpleSourceBean;
import com.example.organizationservice.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    SimpleSourceBean simpleSourceBean;
    public Organization create(Organization organization){
        simpleSourceBean.publishOrganizationChanges("SAVE", organization.getId());
        return organization;

    }
}
