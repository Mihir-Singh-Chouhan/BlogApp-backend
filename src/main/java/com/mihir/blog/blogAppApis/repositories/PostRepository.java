package com.mihir.blog.blogAppApis.repositories;

import com.mihir.blog.blogAppApis.entities.CategoryEntity;
import com.mihir.blog.blogAppApis.entities.PostEntity;
import com.mihir.blog.blogAppApis.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {

List<PostEntity> findByUserEntity(UserEntity userEntity);
List<PostEntity> findByCategoryEntity(CategoryEntity categoryEntity);

List<PostEntity> findByPostTitleContaining(String postTitle);
}
