package com.michelle.bookclub.reader;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michelle.bookclub.book.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledReaders")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

}
