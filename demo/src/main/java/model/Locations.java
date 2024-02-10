package model;


import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Locations {

    private String city;
    private String street;
}
