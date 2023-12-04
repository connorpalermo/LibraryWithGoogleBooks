package com.connorenterprise.controller;

import com.connorenterprise.service.GoogleBooksApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google")
public class GoogleBooksApiController {

    private GoogleBooksApiService googleBooksApiService;

    @Autowired
    private void setGoogleBooksApiService(GoogleBooksApiService googleBooksApiService){
        this.googleBooksApiService = googleBooksApiService;
    }

    @GetMapping("/countByTitle")
    public ResponseEntity<String> countByTitle(@RequestParam("title") String title) throws JsonProcessingException {
        return ResponseEntity.accepted().body(googleBooksApiService.bookCountByTitle(title));
    }

    @GetMapping("/searchByIsbn")
    public ResponseEntity<String> searchByIsbn(@RequestParam("isbn") String isbn) throws JsonProcessingException {
        return ResponseEntity.accepted().body(googleBooksApiService.searchByIsbn(isbn));
    }
}
