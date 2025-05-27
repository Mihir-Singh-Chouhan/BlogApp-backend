package com.company.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String postTitle;

    private String postContent;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    private CategoryEntity categoryEntity;
    @ManyToOne
    private UserEntity userEntity;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<CommentEntity> commentEntitySet = new HashSet<>();

    /**
     * Getter method for property <tt>postId</tt>.
     *
     * @return property value of postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * Setter method for property <tt>postId</tt>.
     *
     * @param postId value to be assigned to property postId
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * Getter method for property <tt>postTitle</tt>.
     *
     * @return property value of postTitle
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * Setter method for property <tt>postTitle</tt>.
     *
     * @param postTitle value to be assigned to property postTitle
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * Getter method for property <tt>postContent</tt>.
     *
     * @return property value of postContent
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * Setter method for property <tt>postContent</tt>.
     *
     * @param postContent value to be assigned to property postContent
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    /**
     * Getter method for property <tt>imageName</tt>.
     *
     * @return property value of imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Setter method for property <tt>imageName</tt>.
     *
     * @param imageName value to be assigned to property imageName
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * Getter method for property <tt>addedDate</tt>.
     *
     * @return property value of addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * Setter method for property <tt>addedDate</tt>.
     *
     * @param addedDate value to be assigned to property addedDate
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * Getter method for property <tt>categoryEntity</tt>.
     *
     * @return property value of categoryEntity
     */
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    /**
     * Setter method for property <tt>categoryEntity</tt>.
     *
     * @param categoryEntity value to be assigned to property categoryEntity
     */
    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    /**
     * Getter method for property <tt>userEntity</tt>.
     *
     * @return property value of userEntity
     */
    public UserEntity getUserEntity() {
        return userEntity;
    }

    /**
     * Setter method for property <tt>userEntity</tt>.
     *
     * @param userEntity value to be assigned to property userEntity
     */
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    /**
     * Getter method for property <tt>commentEntitySet</tt>.
     *
     * @return property value of commentEntitySet
     */
    public Set<CommentEntity> getCommentEntitySet() {
        return commentEntitySet;
    }

    /**
     * Setter method for property <tt>commentEntitySet</tt>.
     *
     * @param commentEntitySet value to be assigned to property commentEntitySet
     */
    public void setCommentEntitySet(Set<CommentEntity> commentEntitySet) {
        this.commentEntitySet = commentEntitySet;
    }
}
