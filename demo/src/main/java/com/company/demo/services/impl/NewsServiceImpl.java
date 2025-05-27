package com.company.demo.services.impl;

import com.company.demo.constants.AppConstants;
import com.company.demo.dto.request.NewsRequest;
import com.company.demo.services.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.access.key}")
    private String API_URL_KEY;

    @Override
    public NewsRequest getNews() {
    NewsRequest news = restTemplate.getForObject(AppConstants.API_URL + API_URL_KEY,NewsRequest.class);
        return news;
    }
}
