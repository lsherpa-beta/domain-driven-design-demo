package com.ddd.LibraryService.catalog.application;

import com.ddd.LibraryService.UseCase;
import com.ddd.LibraryService.catalog.domain.Book;
import com.ddd.LibraryService.catalog.domain.BookRepository;
import com.ddd.LibraryService.catalog.domain.Isbn;
import org.springframework.stereotype.Service;

@UseCase
public class AddBookToCatalogUseCase {

    private  final IsbnSearchService isbnSearchService;
    private  final BookRepository bookRepository;

    public AddBookToCatalogUseCase(IsbnSearchService isbnSearchService, BookRepository bookRepository) {
        this.isbnSearchService = isbnSearchService;
        this.bookRepository = bookRepository;
    }

    public void execute(Isbn isbn){

        BookInformation bookInformation = isbnSearchService.search(isbn);
        bookRepository.save(new Book(bookInformation.title(), isbn));

    }

}
