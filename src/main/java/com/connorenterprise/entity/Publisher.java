package com.connorenterprise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=false)
    private int id;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "description")
    private String description;

    public Publisher(){
        this.id = 0;
        this.publisherName = "Not a Real Person";
        this.description = "A fake ghoulie or ghost of sorts";
    }
}
