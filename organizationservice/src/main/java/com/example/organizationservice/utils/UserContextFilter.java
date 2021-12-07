package com.example.organizationservice.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserContextFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        UserContextHolder.getUserContext().setCorrelationId(request.getHeader(UserContext.CORRELATION_ID));
        UserContextHolder.getUserContext().setAuthToken(request.getHeader(UserContext.AUTH_TOKEN));
        UserContextHolder.getUserContext().setUserId(request.getHeader(UserContext.USER_ID));
        UserContextHolder.getUserContext().setOrganizationId(request.getHeader(UserContext.ORGANIZATION_ID));

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
