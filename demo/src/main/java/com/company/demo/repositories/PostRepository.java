package com.company.demo.repositories;

import com.company.demo.entities.CategoryEntity;
import com.company.demo.entities.PostEntity;
import com.company.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {

List<PostEntity> findByUserEntity(UserEntity userEntity);
List<PostEntity> findByCategoryEntity(CategoryEntity categoryEntity);

List<PostEntity> findByPostTitleContaining(String postTitle);
}
