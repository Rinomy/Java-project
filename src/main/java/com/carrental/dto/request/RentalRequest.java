package com.carrental.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Schema(description = "Аренда Авто")
public record RentalRequest(

        Integer userId,
        Integer carId,
        Date rental_start_date,
        Date rental_end_date,
        Double cost,
        String paymentStatus
) {
}
