package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Production {
    @Id
            @GeneratedValue
    private  int id;
    private String name;
    private int quantity;
    private long price;
    public Production(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

}
