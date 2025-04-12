package com.carrental.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Пользователь")
public record UserRequest(
        @Schema(description = "Имя", examples = "Sasha", requiredMode = REQUIRED)
        @NotBlank
        @Size(max = 100)
        String name,
        String email,
        String password,
        String phoneNumber,
        String address
) {
}
