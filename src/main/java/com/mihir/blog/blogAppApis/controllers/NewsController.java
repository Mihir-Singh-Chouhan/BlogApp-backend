package com.mihir.blog.blogAppApis.controllers;

import com.mihir.blog.blogAppApis.dto.request.NewsRequest;
import com.mihir.blog.blogAppApis.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<NewsRequest> getNews(){
      return ResponseEntity.ok(newsService.getNews());
  }

}
