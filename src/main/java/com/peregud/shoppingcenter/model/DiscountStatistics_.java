package com.peregud.shoppingcenter.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;

@StaticMetamodel(Discount.class)
public class DiscountStatistics_ implements Serializable {
    public static volatile SingularAttribute<DiscountStatistics, Integer> id;
    public static volatile SingularAttribute<DiscountStatistics, String> discount;
}
