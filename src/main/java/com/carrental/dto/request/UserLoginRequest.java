package com.carrental.dto.request;

public record UserLoginRequest(
        String email,
        String password
) {
}
