package com.connorenterprise.controller;

import com.connorenterprise.entity.Book;
import com.connorenterprise.service.GoogleBooksApiService;
import com.connorenterprise.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local")
@Slf4j
public class BookController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private GoogleBooksApiService googleBooksApiService;

    @GetMapping("/test-connection")
    public static ResponseEntity<String> testConnectivity(){
        return ResponseEntity.accepted().body("Spring Application is Running!");
    }

    @PostMapping("/save-book")
    public ResponseEntity<String> saveBook(@RequestBody Book book) throws JsonProcessingException {
        String bookTitle = null;

        bookTitle = googleBooksApiService.searchByIsbn(book.getIsbn());

        if(bookTitle == null){
            String msg = "Book with ISBN: " + book.getIsbn() + " does not exist.";
            log.error(msg);
            return ResponseEntity.badRequest().body(msg);
        }
        String response = libraryService.saveBook(book);
        return ResponseEntity.accepted().body(response);
    }
}
