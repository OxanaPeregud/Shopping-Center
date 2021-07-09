package com.peregud.shoppingcenter.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;

@StaticMetamodel(Shop.class)
public class Shop_ implements Serializable {
    public static volatile SingularAttribute<Shop, Integer> id;
    public static volatile SingularAttribute<Shop, String> name;
    public static volatile SingularAttribute<Shop, String> description;
    public static volatile SingularAttribute<Shop, String> location;
    public static volatile SingularAttribute<Shop, String> email;
    public static volatile SingularAttribute<Shop, Long> mobile;
}
