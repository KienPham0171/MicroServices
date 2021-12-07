package com.example.organizationservice.controller;

import com.example.organizationservice.model.Organization;
import com.example.organizationservice.service.OrganizationService;
import com.example.organizationservice.utils.UserContext;
import com.example.organizationservice.utils.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {
    OrganizationService service;
    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/v1/organization/{organizationId}",method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable(value = "organizationId") String organizationId) {
        UserContext userContext = UserContextHolder.getUserContext();
        System.out.println("correlation Id = "+userContext.getCorrelationId());
        return new Organization(organizationId,"Something has just added");
    }
    @PostMapping(value = "/v1/organization")
    public Organization createOrganization(@RequestBody Organization organization)
    {
        return service.create(organization);
    }
}
