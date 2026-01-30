package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @ManyToOne
    private Customer customer;
}
