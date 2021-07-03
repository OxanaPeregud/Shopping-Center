package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConverterImpl {
    private static final Map<Class<?>, Converter<?>> CONVERTER_MAP;
    private static final Converter<Shop> SHOP_CONVERTER;

    static {
        CONVERTER_MAP = new HashMap<>();
        SHOP_CONVERTER = new ShopConverter();
        CONVERTER_MAP.put(Shop.class, SHOP_CONVERTER);
    }

    public static Converter<?> getConverter(Class<?> clazz) throws Exception {
        return Optional.ofNullable(CONVERTER_MAP.get(clazz)).orElseThrow(Exception::new);
    }
}
