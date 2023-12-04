package com.connorenterprise.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=false)
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "description")
    private String description;

    public Author(){
        this.id = 0;
        this.authorName = "Not a Real Person";
        this.description = "A fake ghoulie or ghost of sorts";
    }
}
