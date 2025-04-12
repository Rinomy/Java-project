package com.carrental.controller;

import com.carrental.dto.request.UserRequest;
import com.carrental.dto.response.UserResponse;
import com.carrental.servecis.UserService;
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
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "user-controller", description = "API для пользователей")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Создаёт пользователя")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse create(@RequestBody @Valid UserRequest request) {
        return userService.createUser(request);
    }

    @Operation(summary = "Обновляет пользователя")
    @PutMapping(path = "/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody @Valid UserRequest request) {
        return userService.updateUser(id, request);
    }

    @Operation(summary = "Предоставляет пользователя")
    @GetMapping(path = "/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Предоставляет всех пользователей")
    @GetMapping
    public Page<UserResponse> getAll(@ParameterObject @PageableDefault Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @Operation(summary = "Удаляет пользователя")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
