package com.carrental.dto.response;


import com.carrental.enums.PaymentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;
@Schema(description = "Аренда Авто")
public record RentalResponse(
        Long id,
        Long userId,
        Long carId,
        LocalDateTime rentalStartDate,
        LocalDateTime rentalEndDate,
        Double cost,
        PaymentStatus paymentStatus
) {

}
