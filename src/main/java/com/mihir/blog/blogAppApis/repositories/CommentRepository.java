package com.mihir.blog.blogAppApis.repositories;

import com.mihir.blog.blogAppApis.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
}
