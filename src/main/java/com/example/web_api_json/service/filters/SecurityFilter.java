package com.example.web_api_json.service.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class SecurityFilter extends HttpFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("key");

        if(token != null && token.equals("pass")){
            chain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            LOGGER.error("Unauthorized. Status " + response.getStatus());
        }
    }
}
