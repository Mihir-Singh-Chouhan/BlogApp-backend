package com.company.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CategoryRequest {

    private Integer categoryId;

    @NotBlank
    @Size(min = 5,message = "Title must have atleast 5 charaters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 5,max = 100,message = "Description contains 5-100 charaters")
    private String categoryDescription;

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
}
