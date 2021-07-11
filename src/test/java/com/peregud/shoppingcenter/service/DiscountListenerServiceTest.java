package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.DiscountStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountListenerServiceTest {
    DiscountListenerService discountListenerService = new DiscountListenerService();
    DiscountStatistics discountStatistics1 = DiscountStatistics.builder()
            .discount("50")
            .build();
    DiscountStatistics discountStatistics2 = DiscountStatistics.builder()
            .discount("10")
            .build();

    @Test
    void save_success() {
        assertEquals(discountStatistics1, discountListenerService.save("50"));
    }

    @Test
    void save_fail() {
        assertNotEquals(discountStatistics2, discountListenerService.save("50"));
    }
}
