package com.company.demo.dto.response;

import com.company.demo.dto.request.PostRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor

public class PostResponse {
    private List<PostRequest> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;

    /**
     * Getter method for property <tt>content</tt>.
     *
     * @return property value of content
     */
    public List<PostRequest> getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(List<PostRequest> content) {
        this.content = content;
    }

    /**
     * Getter method for property <tt>pageNumber</tt>.
     *
     * @return property value of pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Setter method for property <tt>pageNumber</tt>.
     *
     * @param pageNumber value to be assigned to property pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Getter method for property <tt>pageSize</tt>.
     *
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property <tt>pageSize</tt>.
     *
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Getter method for property <tt>totalElements</tt>.
     *
     * @return property value of totalElements
     */
    public long getTotalElements() {
        return totalElements;
    }

    /**
     * Setter method for property <tt>totalElements</tt>.
     *
     * @param totalElements value to be assigned to property totalElements
     */
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * Getter method for property <tt>totalPages</tt>.
     *
     * @return property value of totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Setter method for property <tt>totalPages</tt>.
     *
     * @param totalPages value to be assigned to property totalPages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Getter method for property <tt>lastPage</tt>.
     *
     * @return property value of lastPage
     */
    public boolean isLastPage() {
        return lastPage;
    }

    /**
     * Setter method for property <tt>lastPage</tt>.
     *
     * @param lastPage value to be assigned to property lastPage
     */
    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}

