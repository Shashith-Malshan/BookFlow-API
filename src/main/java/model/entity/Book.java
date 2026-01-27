package model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Books")
public class Book {

    @Id
    private String isbn;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private BigDecimal price;
    private int stock;

    @ManyToOne
    private Author author;
}
