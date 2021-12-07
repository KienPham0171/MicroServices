package com.example.licensingservice.service.client;

import com.example.licensingservice.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrganizationDiscoveryClient {

    @Autowired
    DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("organization-service");
        String svUri = serviceInstances.get(0).getUri().toString();
        String templateUri = String.format("%s/v1/organization/%s",svUri,organizationId);
        System.out.println(templateUri);
        ResponseEntity<Organization> response =
                restTemplate.exchange(templateUri, HttpMethod.GET,null,Organization.class,organizationId);
        return response.getBody();
    }
}
