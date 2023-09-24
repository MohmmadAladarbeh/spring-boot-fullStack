package com.rest.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value ="/api/v1")
public class BookController {

    BookServices bookServices;

    @PostMapping ("/post")
    public void postPosts () {
        List <Book> postList = JonPlaceHolderLayer.getListOfPost();
        for (Book post: postList) {
            bookServices.addNewBook(post);
        }
    }




}
