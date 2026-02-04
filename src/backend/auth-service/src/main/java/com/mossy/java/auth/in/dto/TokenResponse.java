package com.mossy.java.auth.in.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}
