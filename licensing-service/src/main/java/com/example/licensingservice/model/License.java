package com.example.licensingservice.model;

import lombok.Data;

@Data
public class License {
    private long licenseId;
    private String licenseType;
    private Organization organization;

    public License(long licenseId, String licenseType) {
        this.licenseId = licenseId;
        this.licenseType = licenseType;
    }

    public License() {
    }

    public long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(long licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }
}
