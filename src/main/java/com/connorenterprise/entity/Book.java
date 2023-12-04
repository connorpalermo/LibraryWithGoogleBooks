package com.connorenterprise.entity;

import com.connorenterprise.repository.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=false)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_publisher")
    private String bookPublisher;

    @Column(name = "description")
    private String description;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Author author;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Publisher publisher;


    public Book(){
        this.id = 0;
        this.bookName = "You Will Never Read This";
        this.bookAuthor = "Another Fake Person";
        this.bookPublisher = "Fake Person";
        this.description = "Who cares, it doesn't exist";
        this.isbn = "123-456-789";
        this.author = null;
        this.publisher = null;
    }
}
