package com.mihir.blog.blogAppApis.repositories;

import com.mihir.blog.blogAppApis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
