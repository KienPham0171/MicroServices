package com.example.licensingservice.service;

import com.example.licensingservice.model.License;
import com.example.licensingservice.model.Organization;
import com.example.licensingservice.service.client.OrganizationDiscoveryClient;
import com.example.licensingservice.service.client.OrganizationFeignClient;
import com.example.licensingservice.service.client.OrganizationRestTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    @Autowired
    OrganizationFeignClient organizationFeignClient;

    @Autowired
    OrganizationRestTemplateClient organizationRestClient;

    @Autowired
    OrganizationDiscoveryClient organizationDiscoveryClient;

    public License getLicense(long licenceId,String organizationId,String clientType){
        License license = new License(licenceId,"Something like this");
        Organization organization = retrieveOrganizationInfo(organizationId,
                clientType);

        if(organization != null)
        {
            license.setOrganization(organization);
        }
        return license;
    }

    private Organization retrieveOrganizationInfo(String organizationId, String clientType) {
        Organization organization = null;
        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
                break;
        }

        return organization;
    }
}
