package com.company.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class PostRequest {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryRequest category;
    private UserRequest user;

    private Set<CommentRequest> commentEntitySet = new HashSet<>();

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
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Getter method for property <tt>category</tt>.
     *
     * @return property value of category
     */
    public CategoryRequest getCategory() {
        return category;
    }

    /**
     * Setter method for property <tt>category</tt>.
     *
     * @param category value to be assigned to property category
     */
    public void setCategory(CategoryRequest category) {
        this.category = category;
    }

    /**
     * Getter method for property <tt>user</tt>.
     *
     * @return property value of user
     */
    public UserRequest getUser() {
        return user;
    }

    /**
     * Setter method for property <tt>user</tt>.
     *
     * @param user value to be assigned to property user
     */
    public void setUser(UserRequest user) {
        this.user = user;
    }

    /**
     * Getter method for property <tt>commentEntitySet</tt>.
     *
     * @return property value of commentEntitySet
     */
    public Set<CommentRequest> getCommentEntitySet() {
        return commentEntitySet;
    }

    /**
     * Setter method for property <tt>commentEntitySet</tt>.
     *
     * @param commentEntitySet value to be assigned to property commentEntitySet
     */
    public void setCommentEntitySet(Set<CommentRequest> commentEntitySet) {
        this.commentEntitySet = commentEntitySet;
    }
}
