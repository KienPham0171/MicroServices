package com.example.organizationservice.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class UserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.set(UserContext.CORRELATION_ID , UserContextHolder.getUserContext().getCorrelationId());
        headers.set(UserContext.AUTH_TOKEN , UserContextHolder.getUserContext().getAuthToken());
       return  execution.execute(request,body);
    }
}
