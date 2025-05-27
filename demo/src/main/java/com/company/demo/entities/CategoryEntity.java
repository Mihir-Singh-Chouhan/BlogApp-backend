package com.company.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "title")
    private String categoryTitle;

    @Column(name = "description")
    private String categoryDescription;

    @OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
    private List<PostEntity> postEntities = new ArrayList<>();

    /**
     * Getter method for property <tt>categoryId</tt>.
     *
     * @return property value of categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Setter method for property <tt>categoryId</tt>.
     *
     * @param categoryId value to be assigned to property categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Getter method for property <tt>categoryTitle</tt>.
     *
     * @return property value of categoryTitle
     */
    public String getCategoryTitle() {
        return categoryTitle;
    }

    /**
     * Setter method for property <tt>categoryTitle</tt>.
     *
     * @param categoryTitle value to be assigned to property categoryTitle
     */
    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    /**
     * Getter method for property <tt>categoryDescription</tt>.
     *
     * @return property value of categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Setter method for property <tt>categoryDescription</tt>.
     *
     * @param categoryDescription value to be assigned to property categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * Getter method for property <tt>postEntities</tt>.
     *
     * @return property value of postEntities
     */
    public List<PostEntity> getPostEntities() {
        return postEntities;
    }

    /**
     * Setter method for property <tt>postEntities</tt>.
     *
     * @param postEntities value to be assigned to property postEntities
     */
    public void setPostEntities(List<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }
}
