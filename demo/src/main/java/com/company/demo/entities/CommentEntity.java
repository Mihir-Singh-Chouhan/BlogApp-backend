package com.company.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne
    private PostEntity post;

    @ManyToOne
    private UserEntity user;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>content</tt>.
     *
     * @return property value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter method for property <tt>post</tt>.
     *
     * @return property value of post
     */
    public PostEntity getPost() {
        return post;
    }

    /**
     * Setter method for property <tt>post</tt>.
     *
     * @param post value to be assigned to property post
     */
    public void setPost(PostEntity post) {
        this.post = post;
    }

    /**
     * Getter method for property <tt>user</tt>.
     *
     * @return property value of user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Setter method for property <tt>user</tt>.
     *
     * @param user value to be assigned to property user
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
