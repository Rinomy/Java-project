package com.carrental.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Авто")
public record CarRequest(
        @Schema(description = "Кампание Создателя", examples = "TOYOTA", requiredMode = REQUIRED)
        String company,

        @Schema(description = "Модель", examples = "BMW", requiredMode = REQUIRED)
        String model,
        @Schema(description = "Год создание авто",requiredMode = REQUIRED)
        Integer year,
        @Schema(description = "Цвет Авто",requiredMode = REQUIRED)
        String color,
        @Schema(description = "Номера Авто", examples = "000-ee-000", requiredMode = REQUIRED)
        String licensePlate,
        @Schema(description = "Цена за 24 часа", examples = "40",requiredMode = REQUIRED)
        Double rentalPricePerDay
) {
}
