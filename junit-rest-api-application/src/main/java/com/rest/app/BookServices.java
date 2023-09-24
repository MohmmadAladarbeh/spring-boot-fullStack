package com.rest.app;

import org.springframework.beans.factory.annotation.Autowired;

public class BookServices  {

    @Autowired
    BookRepository bookRepository;

    public void addNewBook (Book book) {
        bookRepository.save(book);
    }
}
