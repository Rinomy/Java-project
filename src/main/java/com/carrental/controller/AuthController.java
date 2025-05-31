package com.carrental.controller;

import com.carrental.dto.request.UserLoginRequest;
import com.carrental.dto.response.JwtAuthResponse;
import com.carrental.servecis.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public JwtAuthResponse login(@RequestBody @Valid UserLoginRequest request) {
        return authService.login(request);
    }
}
