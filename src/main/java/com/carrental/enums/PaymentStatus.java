package com.carrental.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum PaymentStatus {
    PAYED, NOT_PAYED
}
