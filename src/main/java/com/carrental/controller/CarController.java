package com.carrental.controller;

import com.carrental.dto.request.CarRequest;
import com.carrental.dto.response.CarResponse;
import com.carrental.dto.response.RentalResponse;
import com.carrental.servecis.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
@Tag(name = "car-controller", description = "API для авто")
public class CarController {

    private final RentalService rentalService;

    @Operation(summary = "Создаёт авто")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CarResponse  create(@RequestBody @Valid CarRequest request) {
        return rentalService.createCar(request);
    }

    @Operation(summary = "Обновляет Авто")
    @PutMapping(path = "/{id}")
    public CarResponse update(@PathVariable Long id, @RequestBody @Valid CarRequest request) {
        return rentalService.updateCar(id, request);
    }

    @Operation(summary = "Предоставляет Авто")
    @GetMapping(path = "/{id}")
    public CarResponse getById(@PathVariable Long id) {
        return rentalService.getCarById(id);
    }

    @Operation(summary = "Аренда Авто")
    @PostMapping(path = "/rent-car/{carId}/{userId}")
    public RentalResponse rentCar(@PathVariable Long carId, @PathVariable Long userId){
        return rentalService.rentCar(userId, carId);
    }

    @Operation(summary = "Предоставляет все Авто")
    @GetMapping
    public Page<CarResponse> getAll(@ParameterObject @PageableDefault Pageable pageable) {
        return rentalService.getAllCars(pageable);
    }

    @Operation(summary = "Удаляет Авто")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        rentalService.deleteCar(id);
    }
}
