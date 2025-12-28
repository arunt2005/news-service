package com.apps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Value("${news.api.url}")
    private String apiUrl;

    @Value("${news.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTopNews(String country) {
        String url = apiUrl +
                "?country=" + country +
                "&apiKey=" + apiKey;

        return restTemplate.getForObject(url, String.class);
    }
}
