package com.ddd.LibraryService.catalog.infrastructure;

import com.ddd.LibraryService.catalog.application.BookInformation;
import com.ddd.LibraryService.catalog.application.IsbnSearchService;
import com.ddd.LibraryService.catalog.domain.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BookSearchService implements IsbnSearchService {


    private final RestClient restClient;

    public BookSearchService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://openlibrary.org/")
                .build();
    }


    public BookInformation search (Isbn isbn){
        OpenLibraryIsbnSearchResult result = restClient.get().uri("isbn/{isbn}.json", isbn.value())
                .retrieve()
                .body(OpenLibraryIsbnSearchResult.class);
        return new BookInformation(result.title());
    }

}
