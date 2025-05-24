package com.carrental.dto.response;

public record JwtAuthResponse(
        String accessToken,
        String tokenType
) {
    private static final String BEARER = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this(accessToken, BEARER);
    }
}
