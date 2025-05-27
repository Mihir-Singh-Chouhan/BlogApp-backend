package com.company.demo.services;

import com.company.demo.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    UserRequest createUser(UserRequest user);
    UserRequest updateUser(UserRequest user, Integer userId);
    UserRequest getUserById(Integer userId);
    List<UserRequest> getAllUsers();
    void deleteUser(Integer userId);
}
