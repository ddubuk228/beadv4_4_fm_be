package com.mossy.java.auth.in.dto;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {}
