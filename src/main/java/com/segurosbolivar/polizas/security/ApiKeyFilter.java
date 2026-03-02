package com.segurosbolivar.polizas.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {

    private static final String API_KEY = "123456";

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = http.getRequestURI();
        
        if (path.startsWith("/h2-console")) {
            chain.doFilter(request, response);
            return;
        }

        if (path.startsWith("/core-mock")) {
            chain.doFilter(request, response);
            return;
        }

        String apiKey = http.getHeader("x-api-key");

        if (!API_KEY.equals(apiKey)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("API Key invalida");
            return;
        }

        chain.doFilter(request, response);
    }
}