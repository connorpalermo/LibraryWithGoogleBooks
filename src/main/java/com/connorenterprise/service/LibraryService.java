package com.connorenterprise.service;

import com.connorenterprise.entity.Book;
import com.connorenterprise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public String saveBook(Book book){
        bookRepository.save(book);
        return "Book Saved Successfully!";
    }
}
