package com.example.licensingservice.controller;

import com.example.licensingservice.model.License;
import com.example.licensingservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicensingController {

    LicenseService licenseService;
    @Autowired
    public LicensingController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @RequestMapping(value = "/{licenseId}/{clientType}",method = RequestMethod.GET)
    public License getLicense(
            @PathVariable(value = "organizationId") String organizationId,
            @PathVariable String clientType,
            @PathVariable long licenseId)
    {
        System.out.println("ong da goi toi");
        return licenseService.getLicense(licenseId,organizationId,clientType);
    }

}
