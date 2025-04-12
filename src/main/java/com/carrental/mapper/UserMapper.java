package com.carrental.mapper;

import com.carrental.dto.request.UserRequest;
import com.carrental.dto.response.UserResponse;
import com.carrental.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleId", constant = "2")
    User toEntity(UserRequest request);

    UserResponse toResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleId", ignore = true)
    User updateEntity(@MappingTarget User user, UserRequest request);
}
