package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.model.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAOShopImplTest {
    DAOShopImpl daoShop = new DAOShopImpl();
    Shop shop1 = Shop.builder()
            .id(1)
            .name("Shop1")
            .build();
    Shop shop2 = Shop.builder()
            .id(2)
            .name("Shop2")
            .build();
    Shop shop3 = Shop.builder()
            .id(3)
            .name("Shop3")
            .build();

    @Test
    void save_success() {
        daoShop.save(shop1);
        assertEquals(shop1, daoShop.save(shop1));
    }

    @Test
    void save_fail() {
        daoShop.save(shop1);
        daoShop.save(shop2);
        assertNotEquals(shop1, daoShop.save(shop2));
    }

    @Test
    void getById_success() {
        daoShop.save(shop3);
        assertEquals(shop3, daoShop.getById(Shop.class, shop3.getId()));
    }

    @Test
    void getById_fail() {
        daoShop.save(shop1);
        daoShop.save(shop2);
        assertNotEquals(shop1, daoShop.getById(Shop.class, shop2.getId()));
    }

    @Test
    void delete_success() {
        daoShop.save(shop1);
        daoShop.delete(Shop.class, shop1.getId());
        assertNull(daoShop.getById(Shop.class, shop1.getId()));
    }

    @Test
    void delete_fail() {
        daoShop.save(shop1);
        daoShop.save(shop2);
        daoShop.delete(Shop.class, shop1.getId());
        assertNotNull(daoShop.getById(Shop.class, shop2.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_success() {
        DAOShopImpl daoShop = mock(DAOShopImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(daoShop.getAll(any(Class.class))).thenReturn(list);
        assertEquals(list, daoShop.getAll(Shop.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_fail() {
        DAOShopImpl daoShop = mock(DAOShopImpl.class);
        List<?> list = List.of(shop1, shop2);
        when(daoShop.getAll(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(shop1), daoShop.getAll(Shop.class));
    }
}
