package com.mihir.blog.blogAppApis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mihir.blog.blogAppApis.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
     Optional<UserEntity> findByEmail(String email);
}
