package com.example.licensingservice.configuration;

import com.example.licensingservice.utils.UserContextInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ProjectConfig {
    @LoadBalanced
    @Bean public RestTemplate getRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors =  restTemplate.getInterceptors();
        if (interceptors == null){
            restTemplate.setInterceptors(List.of(new UserContextInterceptor()));
        }else{
            interceptors.add(new UserContextInterceptor());
            restTemplate.setInterceptors(interceptors);
        }
        return restTemplate;
    }
}
