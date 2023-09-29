package com.rest.app;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Long id;
    private Long userId;
    private String title;
    private String body;


    public BookDTO(){}
    public BookDTO(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
