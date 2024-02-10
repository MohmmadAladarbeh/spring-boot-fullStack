package model;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class User {

    private String firstName;
    private String lastName;
    private String age;
    private String phone;
    @Embedded
    private Locations locations;
}
