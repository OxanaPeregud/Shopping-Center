package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Store;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConverterImpl {
    private static final Map<Class<?>, Converter<?>> CONVERTER_MAP;
    private static final Converter<Store> STORE_CONVERTER;

    static {
        CONVERTER_MAP = new HashMap<>();
        STORE_CONVERTER = new StoreConverter();
        CONVERTER_MAP.put(Store.class, STORE_CONVERTER);
    }

    public static Converter<?> getConverter(Class<?> clazz) throws Exception {
        return Optional.ofNullable(CONVERTER_MAP.get(clazz)).orElseThrow(Exception::new);
    }
}
