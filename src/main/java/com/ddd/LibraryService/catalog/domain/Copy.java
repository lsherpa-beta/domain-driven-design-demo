package com.ddd.LibraryService.catalog.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;

public class Copy{

    @EmbeddedId
    private CopyId id;
    @Embedded
    private BareCode bareCode;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id"))
    private BookId bookId;
}
