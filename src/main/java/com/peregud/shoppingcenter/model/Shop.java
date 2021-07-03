package com.peregud.shoppingcenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Indexed(index = "shop")
@Table(name = "shop")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String name;

    @Column
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String description;

    @Column
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
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
