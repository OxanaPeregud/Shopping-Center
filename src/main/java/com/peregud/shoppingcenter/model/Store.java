package com.peregud.shoppingcenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Indexed
@Table(name = "store")
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Field
    private String name;

    @Column
    @Field
    private String description;

    @Column
    private Integer discount;

    @Column(name = "discount_start_date")
    private LocalDate discountStartDate;

    @Column(name = "discount_end_date")
    private LocalDate discountEndDate;

    @Column
    private String location;

    @Column
    private String email;

    @Column
    private Long mobile;
}
