package com.company.demo.services;

import com.company.demo.dto.request.UserRequest;
import com.company.demo.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserRequest createUser(UserRequest user);
    UserRequest updateUser(UserRequest user, Long userId);
    UserRequest getUserById(Long userId);
    List<UserResponse> getAllUsers();
    void deleteUser(Long userId);
}
