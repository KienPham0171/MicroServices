package com.example.gatewayserver.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class TrackingFilter implements GlobalFilter {
    @Autowired
    FilterUtils filterUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders =  exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(requestHeaders)){
            System.out.println("da co header");
        }else{
            System.out.println("chua co header");
            String correlationId = generateCorrelationId();
            exchange =filterUtils.setCorrelationId(exchange,correlationId);
        }
        return chain.filter(exchange);
    }
    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders){
        if(filterUtils.getCorrelationId(requestHeaders) != null){
            return true;
        }else{
            return false;
        }
    }
    private String generateCorrelationId()
    {
        return java.util.UUID.randomUUID().toString();
    }
}
