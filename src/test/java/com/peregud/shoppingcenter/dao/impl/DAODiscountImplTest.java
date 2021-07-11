package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.model.Discount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAODiscountImplTest {
    DAODiscountImpl daoDiscount = new DAODiscountImpl();
    Discount discount1 = Discount.builder()
            .id(1)
            .discount(50)
            .build();
    Discount discount2 = Discount.builder()
            .id(2)
            .discount(45)
            .build();
    Discount discount3 = Discount.builder()
            .id(3)
            .discount(15)
            .build();

    @Test
    void save_success() {
        daoDiscount.save(discount1);
        assertEquals(discount1, daoDiscount.save(discount1));
    }

    @Test
    void save_fail() {
        daoDiscount.save(discount1);
        daoDiscount.save(discount2);
        assertNotEquals(discount1, daoDiscount.save(discount2));
    }

    @Test
    void getById_success() {
        daoDiscount.save(discount3);
        assertEquals(discount3, daoDiscount.getById(Discount.class, discount3.getId()));
    }

    @Test
    void getById_fail() {
        daoDiscount.save(discount1);
        daoDiscount.save(discount2);
        assertNotEquals(discount1, daoDiscount.getById(Discount.class, discount2.getId()));
    }

    @Test
    void delete_success() {
        daoDiscount.save(discount1);
        daoDiscount.delete(Discount.class, discount1.getId());
        assertNull(daoDiscount.getById(Discount.class, discount1.getId()));
    }

    @Test
    void delete_fail() {
        daoDiscount.save(discount1);
        daoDiscount.save(discount2);
        daoDiscount.delete(Discount.class, discount1.getId());
        assertNotNull(daoDiscount.getById(Discount.class, discount2.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_success() {
        DAODiscountImpl daoDiscount = mock(DAODiscountImpl.class);
        List<?> list = List.of(discount1, discount2);
        when(daoDiscount.getAll(any(Class.class))).thenReturn(list);
        assertEquals(list, daoDiscount.getAll(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getAll_fail() {
        DAODiscountImpl daoDiscount = mock(DAODiscountImpl.class);
        List<?> list = List.of(discount1, discount2);
        when(daoDiscount.getAll(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(discount1), daoDiscount.getAll(Discount.class));
    }
}
