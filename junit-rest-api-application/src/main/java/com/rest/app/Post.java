package com.rest.app;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {

    private int id;
    private int userId;
    private String title;
    private String body;


}
