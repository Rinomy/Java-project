package com.carrental.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Авто")
public record CarResponse(
        Long id,
        String company,

        @Schema(description = "Модель", examples = "BMW", requiredMode = REQUIRED)
        String model,

        Integer year,
        String color,
        String licensePlate,
        Double rentalPricePerDay
) {
}
