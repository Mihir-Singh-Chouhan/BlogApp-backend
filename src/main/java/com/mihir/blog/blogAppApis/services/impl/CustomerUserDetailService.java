package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.entities.UserEntity;
import com.mihir.blog.blogAppApis.exceptions.ResourceNotFoundException;
import com.mihir.blog.blogAppApis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomerUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = this.userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User","email: "+username,0));


        return userEntity;
    }
}
