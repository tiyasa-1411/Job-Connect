package com.jobconnect.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {  // Renamed from JwtUtils to JwtHelper

    @Value("${jwt.expiration}")
    private long expiration;

    // Your methods for JWT handling
}