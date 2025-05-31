package com.carrental.mapper;


import com.carrental.dto.response.RentalResponse;
import com.carrental.entity.RentalCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;
@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface RentalMapper {
    @Mapping(target = "cost", source = "totalCost")
    RentalResponse toResponse(RentalCar entity);
}
