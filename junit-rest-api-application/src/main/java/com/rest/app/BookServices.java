package com.rest.app;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServices  {

    @Autowired
    BookRepository bookRepository;

    public void addNewBook (Book book) {
        bookRepository.save(book);
    }
}
