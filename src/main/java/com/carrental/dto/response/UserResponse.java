package com.carrental.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Пользователь")
public record UserResponse(
        Long id,
        @Schema(description = "Имя", examples = "Sasha", requiredMode = REQUIRED)
        String name,
        String email,
        String password,
        String phoneNumber,
        String address
) {
}
