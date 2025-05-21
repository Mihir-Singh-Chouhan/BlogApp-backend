package com.mihir.blog.blogAppApis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mihir.blog.blogAppApis.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
