package com.ddd.LibraryService.catalog.application;

import com.ddd.LibraryService.catalog.domain.Isbn;

public interface IsbnSearchService {
    BookInformation search(Isbn isbn);
}
