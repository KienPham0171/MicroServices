package com.example.gatewayserver.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtils {
    public static final String CORRELATION_ID = "correlation-id";

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setCorrelationIdWithNameAndValue(exchange, CORRELATION_ID, correlationId);
    }

    private ServerWebExchange setCorrelationIdWithNameAndValue(ServerWebExchange exchange, String name, String value) {
        exchange.mutate().request(
                exchange.getRequest().mutate().header(name,value).build()
        ).build();
        return exchange;
    }

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if(requestHeaders.get(CORRELATION_ID)!= null){
            List<String> headers = requestHeaders.get(CORRELATION_ID);
            assert headers != null;
            return headers.stream().findFirst().get();
        }else return null;
    }
}
