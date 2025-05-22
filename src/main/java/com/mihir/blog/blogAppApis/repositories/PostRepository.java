package com.mihir.blog.blogAppApis.repositories;

import com.mihir.blog.blogAppApis.entities.Category;
import com.mihir.blog.blogAppApis.entities.Post;
import com.mihir.blog.blogAppApis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

List<Post> findByUser(User user);
List<Post> findByCategory(Category category);
}
