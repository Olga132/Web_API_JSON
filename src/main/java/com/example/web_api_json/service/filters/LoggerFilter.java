package com.example.web_api_json.service.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class LoggerFilter extends HttpFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(response.getStatus() == 200){
            LOGGER.info("Status Ok.");
        } else {
            LOGGER.error("Status " + response.getStatus() + ". ERROR");
        }
    }
}
