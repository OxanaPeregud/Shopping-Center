package com.peregud.shoppingcenter.dto;

import org.hibernate.transform.ResultTransformer;

import java.util.List;

@FunctionalInterface
public interface ListResultTransformer extends ResultTransformer {

    @Override
    default List<?> transformList(List tuples) {
        return tuples;
    }
}
