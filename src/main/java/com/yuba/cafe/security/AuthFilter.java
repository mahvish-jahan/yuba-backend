package com.yuba.cafe.security;

import com.yuba.cafe.jwt.JwtTokenUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.http.HttpRequest;

@Log4j2
@Component
public class AuthFilter implements Filter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authorizationHeader = httpRequest.getHeader("Authorization");

        if (StringUtils.hasText(authorizationHeader)) {
            String token = authorizationHeader.substring(7);
            System.out.println(token);
            boolean isValid = jwtTokenUtil.validateAccessToken(token);
            if (isValid) {
                chain.doFilter(request, response);
                return;
            }
        }

        HttpServletResponse res = (HttpServletResponse) response;
        res.sendError(HttpStatus.UNAUTHORIZED.value(), "Bearer token missing or expired");
    }
}
