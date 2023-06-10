package com.yuba.cafe.jwt;

import java.io.Serializable;
import java.util.Date;

import com.yuba.cafe.model.User;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Log4j2
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour


    @Value("${jwt.secret}")
    private String secret;

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuer("Yuba")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            log.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            log.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            log.error("Signature validation failed");
        }

        return false;
    }

    public Long getUserIdUsingAuthHeader(String authHeader) {
        String token = getTokenFromHeader(authHeader);
        if (StringUtils.hasText(token)) {
            return getUserId(token);
        }
        return null;
    }

    public String getTokenFromHeader(String header) {
        if (StringUtils.hasText(header)) {
            return header.substring(7);
        }
        return null;
    }

    public Long getUserId(String token) {
        return Long.valueOf(parseClaims(token).getSubject());
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}