package com.example.organizationservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserContext {
    public static final String CORRELATION_ID = "correlation-id";
    public static final String AUTH_TOKEN = "auth-token";
    public static final String USER_ID = "user-id";
    public static final String ORGANIZATION_ID = "organization-id";


    private static final ThreadLocal<String> orgId =
            new ThreadLocal<String>();
    private static final ThreadLocal<String> correlationId= new ThreadLocal<String>();
    private String authToken;
    private String userId;
    private String organizationId;

    public static String getCorrelationId() {
        return correlationId.get();
    }
    public static void setCorrelationId(String cid) {correlationId.set(cid);}
}
