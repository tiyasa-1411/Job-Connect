package com.jobconnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;

    // Additional configurations can be added here

    public String getSecret() {
        return secret;
    }
}
