package com.connorenterprise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GoogleBooksApiConfig {

    @Value("${google.books.url}")
    private String booksUri;

    @Bean
    public RestTemplate googleBooksApiRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(booksUri).build();
    }

}
