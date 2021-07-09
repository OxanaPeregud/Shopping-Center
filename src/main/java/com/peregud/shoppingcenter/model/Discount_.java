package com.peregud.shoppingcenter.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;
import java.time.LocalDate;

@StaticMetamodel(Discount.class)
public class Discount_ implements Serializable {
    public static volatile SingularAttribute<Discount, Integer> id;
    public static volatile SingularAttribute<Discount, Integer> discount;
    public static volatile SingularAttribute<Discount, LocalDate> discountStartDate;
    public static volatile SingularAttribute<Discount, LocalDate> discountEndDate;
    public static volatile SingularAttribute<Discount, Shop> shop;
}
