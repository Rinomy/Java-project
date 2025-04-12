package com.carrental.servecis;

import com.carrental.dto.request.UserRequest;
import com.carrental.dto.response.UserResponse;
import com.carrental.mapper.UserMapper;
import com.carrental.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        var user = userMapper.toEntity(request);
        var savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        return userRepository.findById(id)
                .map(u -> userMapper.updateEntity(u, request))
                .map(userRepository::save)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Предоставляет пользователя по ID.
     *
     * @param id ID пользователя
     * @return пользователь
     */
    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toResponse);
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete user with id: " + id, e);
        }
    }
}
