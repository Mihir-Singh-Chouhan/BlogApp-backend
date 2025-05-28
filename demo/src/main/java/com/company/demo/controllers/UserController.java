package com.company.demo.controllers;

import com.company.demo.dto.request.UserRequest;
import com.company.demo.dto.response.ApiResponse;
import com.company.demo.dto.response.UserResponse;
import com.company.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserRequest> createUser(@Valid @RequestBody UserRequest userRequest)
    {
        UserRequest createUserRequest = userService.createUser(userRequest);
       return new ResponseEntity<>(createUserRequest, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRequest> updateUser(@Valid @RequestBody UserRequest userRequest, @PathVariable("id") Long myId){  //since id and myId both are different strings so we specify here
        UserRequest updatedUserRequest = userService.updateUser(userRequest,myId);
       // return new ResponseEntity<>(updatedUserRequest,HttpStatus.CREATED);
        return ResponseEntity.ok(updatedUserRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> userDelete(@PathVariable Long userId){
        userService.deleteUser(userId);
       return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true), HttpStatus.OK);
    }
}
