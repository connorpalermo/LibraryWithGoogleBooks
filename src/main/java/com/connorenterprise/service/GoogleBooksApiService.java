package com.connorenterprise.service;

import com.connorenterprise.model.GoogleBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleBooksApiService {

    @Autowired
    private RestTemplate googleBooksApiRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // obviously not best practice. If this were a real app, would store this in vault or something
    // and inject at runtime.
    @Value("${google.books.apikey}")
    private String apiKey;

    public String bookCountByTitle(String title) throws JsonProcessingException {
        GoogleBook books =
                objectMapper.readValue(googleBooksApiRestTemplate.getForObject("/volumes?q={title}&key={key}", String.class, title, apiKey), GoogleBook.class);
        return "Books that match title " + title + ": " + books.getTotalItems();
    }

    public String searchByIsbn(String isbn) throws JsonProcessingException {
        GoogleBook books =
                objectMapper.readValue(googleBooksApiRestTemplate.getForObject("/volumes?q=isbn:{isbn}", String.class, isbn), GoogleBook.class);
        return "Book corresponding to isbn " + isbn + " is: " + books.getItems()[0].getVolumeInfo().getTitle();
    }
}
