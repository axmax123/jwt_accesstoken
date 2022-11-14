package com.jwt.sec.product;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    @NotNull
    @Length(min = 5, max = 128)
    private String name;
    private float price;
}