package com.rest.app;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    Long id;

    Long userId;

    @NonNull
    String title;

    @NonNull
    String body;


}
