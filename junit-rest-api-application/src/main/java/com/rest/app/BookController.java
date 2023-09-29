package com.rest.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="/api/v1")
public class BookController {

    BookServices bookServices;

    @Autowired
    BookRepository bookRepository;

    @PostMapping ("/addBooks")
    public void postPosts () {
        List <BookDTO> postList = JonPlaceHolderLayer.getListOfPost();
        for (BookDTO book: postList) {
            Book book_repo = new Book();
            book_repo.setId(book.getId());
            book_repo.setUserId(book.getUserId());
            book_repo.setBody(book.getBody());
            book_repo.setTitle(book.getTitle());
            bookRepository.save(book_repo);
        }
    }

    @PostMapping("/addBook")
    public String addBook (@RequestBody Book book) {
        bookRepository.save(book);
        return "success";
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBOOK (@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    @GetMapping ("/getAllBooks")
    public List<Book> getAllBooks(){

        return bookRepository.findAll();
    }

    @PutMapping("/update")
    public Book update(@RequestBody Book book) throws ChangeSetPersister.NotFoundException {
        if (book == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        if (book.getId() == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        Optional<Book> oldBook = bookRepository.findById(book.getId());
        if (!oldBook.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        Book newBook = oldBook.get();
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setBody(book.getBody());
        newBook.setUserId(book.getUserId());
        return bookRepository.save(book);
    }






}
