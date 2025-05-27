package com.company.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class NewsRequest {
    private String status;
    private Integer totalResults;
    private List<Articles> articles;

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>totalResults</tt>.
     *
     * @return property value of totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * Setter method for property <tt>totalResults</tt>.
     *
     * @param totalResults value to be assigned to property totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * Getter method for property <tt>articles</tt>.
     *
     * @return property value of articles
     */
    public List<Articles> getArticles() {
        return articles;
    }

    /**
     * Setter method for property <tt>articles</tt>.
     *
     * @param articles value to be assigned to property articles
     */
    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @NoArgsConstructor
    public static class Articles{
        private Source source;
        private String author;
        private String title;
        private String url;
        private String urlToImage;
        private String content;
        private Date publishedAt;

        /**
         * Getter method for property <tt>source</tt>.
         *
         * @return property value of source
         */
        public Source getSource() {
            return source;
        }

        /**
         * Setter method for property <tt>source</tt>.
         *
         * @param source value to be assigned to property source
         */
        public void setSource(Source source) {
            this.source = source;
        }

        /**
         * Getter method for property <tt>author</tt>.
         *
         * @return property value of author
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Setter method for property <tt>author</tt>.
         *
         * @param author value to be assigned to property author
         */
        public void setAuthor(String author) {
            this.author = author;
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
         * Getter method for property <tt>url</tt>.
         *
         * @return property value of url
         */
        public String getUrl() {
            return url;
        }

        /**
         * Setter method for property <tt>url</tt>.
         *
         * @param url value to be assigned to property url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * Getter method for property <tt>urlToImage</tt>.
         *
         * @return property value of urlToImage
         */
        public String getUrlToImage() {
            return urlToImage;
        }

        /**
         * Setter method for property <tt>urlToImage</tt>.
         *
         * @param urlToImage value to be assigned to property urlToImage
         */
        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
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
         * Getter method for property <tt>publishedAt</tt>.
         *
         * @return property value of publishedAt
         */
        public Date getPublishedAt() {
            return publishedAt;
        }

        /**
         * Setter method for property <tt>publishedAt</tt>.
         *
         * @param publishedAt value to be assigned to property publishedAt
         */
        public void setPublishedAt(Date publishedAt) {
            this.publishedAt = publishedAt;
        }

        @NoArgsConstructor
        public static class Source {
            private String id;
            private String name;

            /**
             * Getter method for property <tt>id</tt>.
             *
             * @return property value of id
             */
            public String getId() {
                return id;
            }

            /**
             * Setter method for property <tt>id</tt>.
             *
             * @param id value to be assigned to property id
             */
            public void setId(String id) {
                this.id = id;
            }

            /**
             * Getter method for property <tt>name</tt>.
             *
             * @return property value of name
             */
            public String getName() {
                return name;
            }

            /**
             * Setter method for property <tt>name</tt>.
             *
             * @param name value to be assigned to property name
             */
            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
