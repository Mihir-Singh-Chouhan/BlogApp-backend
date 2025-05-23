package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.dto.request.PostRequest;
import com.mihir.blog.blogAppApis.dto.response.PostResponse;
import com.mihir.blog.blogAppApis.entities.CategoryEntity;
import com.mihir.blog.blogAppApis.entities.PostEntity;
import com.mihir.blog.blogAppApis.entities.UserEntity;
import com.mihir.blog.blogAppApis.exceptions.ResourceNotFoundException;
import com.mihir.blog.blogAppApis.repositories.CategoryRepository;
import com.mihir.blog.blogAppApis.repositories.PostRepository;
import com.mihir.blog.blogAppApis.repositories.UserRepository;
import com.mihir.blog.blogAppApis.services.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostRequest createPost(PostRequest postRequest, Integer userId, Integer categoryId) {

        UserEntity userEntity = this.userRepository.findById(userId)
                        .orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));
        CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId)
                                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",categoryId));

        PostEntity creatPostEntity = this.modelMapper.map(postRequest, PostEntity.class);
        creatPostEntity.setImageName("default.png");
        creatPostEntity.setAddedDate(new Date());
        creatPostEntity.setUserEntity(userEntity);
        creatPostEntity.setCategoryEntity(categoryEntity);
        return this.modelMapper.map(this.postRepository.save(creatPostEntity), PostRequest.class);  // or Post newPost = this.postRepository.save(creatPost); use newPost
    }

    @Override
    public PostRequest updatePost(PostRequest postRequest, Integer postId) {
        PostEntity postEntity = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        postEntity.setPostTitle(postRequest.getTitle());
        postEntity.setPostContent(postRequest.getContent());
        postEntity.setImageName(postRequest.getImageName());
        PostEntity updatedPostEntity = this.postRepository.save(postEntity);

        return this.modelMapper.map(updatedPostEntity, PostRequest.class);
    }

    @Override
    public void deletePost(Integer postId) {
        PostEntity postEntity = this.postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        this.postRepository.delete(postEntity);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy) {

        Pageable pages = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));

        Page<PostEntity> pageOfPost = this.postRepository.findAll(pages);

        List<PostEntity> allPostEntities = pageOfPost.getContent();
        List<PostRequest> postRequests = allPostEntities.stream().map((postEntity)->this.modelMapper.map(postEntity, PostRequest.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postRequests);
        postResponse.setPageNumber(pageOfPost.getNumber());
        postResponse.setPageSize(pageOfPost.getSize());
        postResponse.setTotalElements(pageOfPost.getTotalElements());
        postResponse.setTotalPages(pageOfPost.getTotalPages());
        postResponse.setLastPage(pageOfPost.isLast());

      return postResponse;
    }

    @Override
    public PostRequest getPostById(Integer postId) {
       PostEntity postEntity = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id", postId));
      // PostDto convertIntoDto = this.modelMapper.map(post,PostDto.class);
        return this.modelMapper.map(postEntity, PostRequest.class);
    }

    @Override
    public List<PostRequest> getAllPostByCategory(Integer categoryId) {

       CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));

        List<PostEntity> postEntities = this.postRepository.findByCategoryEntity(categoryEntity);

        //Use streamApi to convert post -> postDto using lambda
        //List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postEntities.stream().map((postEntity) -> this.modelMapper.map(postEntity, PostRequest.class)).collect(Collectors.toList());  // or uncomment above line and return postDtos
    }

    @Override
    public List<PostRequest> getAllPostByUser(Integer userId) {
        UserEntity userEntity = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));

        List<PostEntity> postEntities = this.postRepository.findByUserEntity(userEntity);

        //Use streamApi to convert post -> postDto using lambda
        //List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postEntities.stream().map((postEntity) -> this.modelMapper.map(postEntity, PostRequest.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostRequest> searchPosts(String keyword) {
        List<PostEntity> postEntities = this.postRepository.findByPostTitleContaining(keyword);
        return postEntities.stream().map((postEntity)->this.modelMapper.map(postEntity, PostRequest.class)).collect(Collectors.toList());

    }
}
