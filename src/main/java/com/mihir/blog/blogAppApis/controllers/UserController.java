package com.mihir.blog.blogAppApis.controllers;

import com.mihir.blog.blogAppApis.dto.response.ApiResponse;
import com.mihir.blog.blogAppApis.dto.request.UserRequest;
import com.mihir.blog.blogAppApis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserRequest>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRequest> updateUser(@Valid @RequestBody UserRequest userRequest, @PathVariable("id") Integer myId){  //since id and myId both are different strings so we specify here
        UserRequest updatedUserRequest = userService.updateUser(userRequest,myId);
       // return new ResponseEntity<>(updatedUserRequest,HttpStatus.CREATED);
        return ResponseEntity.ok(updatedUserRequest);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> userDelete(@PathVariable Integer userId){
        userService.deleteUser(userId);
       return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true), HttpStatus.OK);
    }
}
