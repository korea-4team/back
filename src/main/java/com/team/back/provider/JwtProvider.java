package com.team.back.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
    
    @Value("${secret-key}")
    private String secretKey;

    public String create(String userEmail) {
        Date expiredDate = Date.from(Instant.now().plus(5, ChronoUnit.HOURS));

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey)
        .setSubject(userEmail).setIssuedAt(new Date()).setExpiration(expiredDate).compact();

        return jwt;
    }

    public String validate(String jwt) {
        Claims payload = null;

        try {
            payload = Jwts.parser().setSigningKey(secretKey)
            .parseClaimsJws(jwt).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return payload.getSubject();
    }
}
