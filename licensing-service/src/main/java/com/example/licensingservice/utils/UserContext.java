package com.example.licensingservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContext {
    public static final String CORRELATION_ID = "correlation-id";
    public static final String AUTH_TOKEN = "auth-token";
    public static final String USER_ID = "user-id";
    public static final String ORGANIZATION_ID = "organization-id";


    private String correlationId;
    private String authToken;
    private String userId;
    private String organizationId;

}
