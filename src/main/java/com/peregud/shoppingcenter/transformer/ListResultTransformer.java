package com.peregud.shoppingcenter.transformer;

import org.hibernate.transform.ResultTransformer;

import java.util.List;

@FunctionalInterface
public interface ListResultTransformer extends ResultTransformer {

    @Override
    default List<?> transformList(List tuples) {
        return tuples;
    }
}
