package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Discount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletDiscountServiceTest {
    ServletDiscountService servletDiscountService = new ServletDiscountService();
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
            .discount(10)
            .build();

    @Test
    void save_success() {
        assertEquals(discount1, servletDiscountService.save(discount1));
    }

    @Test
    void save_fail() {
        assertNotEquals(discount2, servletDiscountService.save(discount1));
    }

    @Test
    void getById_success() {
        servletDiscountService.save(discount1);
        assertEquals(discount3, servletDiscountService.getById(Discount.class, discount3.getId()));
    }

    @Test
    void getById_fail() {
        servletDiscountService.save(discount1);
        servletDiscountService.save(discount2);
        assertNotEquals(discount2, servletDiscountService.getById(Discount.class, discount1.getId()));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_success() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        List<?> list = List.of(discount1, discount2);
        when(servletDiscountService.getList(any(Class.class))).thenReturn(list);
        assertEquals(list, servletDiscountService.getList(Discount.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    void getList_fail() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        List<?> list = List.of(discount1, discount2);
        when(servletDiscountService.getList(any(Class.class))).thenReturn(list);
        assertNotEquals(List.of(discount1), servletDiscountService.getList(Discount.class));
    }

    @Test
    void delete_success() {
        servletDiscountService.save(discount1);
        servletDiscountService.delete(Discount.class, discount1.getId());
        assertNull(servletDiscountService.getById(Discount.class, discount1.getId()));
    }

    @Test
    void delete_fail() {
        servletDiscountService.save(discount1);
        servletDiscountService.save(discount2);
        servletDiscountService.delete(Discount.class, discount1.getId());
        assertNotNull(servletDiscountService.getById(Discount.class, discount2.getId()));
    }

    @Test
    void getSet_success() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        Set<Discount> set = Set.of(discount1, discount2);
        List<Integer> discountIdList = new ArrayList<>();
        when(servletDiscountService.getSet(any())).thenReturn(set);
        assertEquals(set, servletDiscountService.getSet(discountIdList));
    }

    @Test
    void getSet_fail() {
        ServletDiscountService servletDiscountService = mock(ServletDiscountService.class);
        Set<Discount> set = Set.of(discount1, discount2);
        List<Integer> discountIdList = new ArrayList<>();
        when(servletDiscountService.getSet(any())).thenReturn(set);
        assertNotEquals(Set.of(discount1), servletDiscountService.getSet(discountIdList));
    }
}
