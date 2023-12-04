package com.connorenterprise.controller;

import com.connorenterprise.entity.Book;
import com.connorenterprise.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local")
public class BookController {

    private LibraryService libraryService;

    @Autowired
    private void setSpringRestService(LibraryService libraryService){ this.libraryService = libraryService;}

    @GetMapping("/test-connection")
    public static ResponseEntity<String> testConnectivity(){
        return ResponseEntity.accepted().body("Spring Application is Running!");
    }

    @PostMapping("/save-book")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        String response = libraryService.saveBook(book);
        return ResponseEntity.accepted().body(response);
    }
}
