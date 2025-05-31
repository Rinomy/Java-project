package com.carrental.entity;


import com.carrental.enums.PaymentStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("rentals")
public class RentalCar {
    @Id
    @Column("rental_id")
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalEndDate;
    private Double totalCost;
    private PaymentStatus paymentStatus;
    private LocalDateTime createdAt;

}
