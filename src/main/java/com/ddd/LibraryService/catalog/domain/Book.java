package com.ddd.LibraryService.catalog.domain;

import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
public class Book {
    @EmbeddedId
    private BookId id;
    private String title;
    @Embedded
    @AttributeOverride( name = "value", column = @Column(name = "isbn"))
    private Isbn isbn;
    //Because Hibernate wants the default constructor
    Book() {
    }

    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(isbn, "isbn must not be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }

    public BookId getId() {
        return id;
    }

    public void setId(BookId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }
}
