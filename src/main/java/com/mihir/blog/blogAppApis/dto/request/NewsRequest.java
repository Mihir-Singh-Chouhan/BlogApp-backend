package com.mihir.blog.blogAppApis.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class NewsRequest {
    private String status;
    private Integer totalResults;
    private List<Articles> articles;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Articles{
        private Source source;
        private String author;
        private String title;
        private String url;
        private String urlToImage;
        private String content;
        private Date publishedAt;

        @Getter
        @Setter
        @NoArgsConstructor
        public static class Source {
            private String id;
            private String name;
        }
    }
}
