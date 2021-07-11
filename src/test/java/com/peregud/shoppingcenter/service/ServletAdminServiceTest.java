package com.peregud.shoppingcenter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServletAdminServiceTest {

    @Test
    void findAdmin_success() {
        ServletAdminService servletAdminService = mock(ServletAdminService.class);
        when(servletAdminService.findAdmin("name", "password")).thenReturn(true);
        assertTrue(servletAdminService.findAdmin("name", "password"));
    }

    @Test
    void findAdmin_fail() {
        ServletAdminService servletAdminService = mock(ServletAdminService.class);
        when(servletAdminService.findAdmin("name", "password")).thenReturn(true);
        assertFalse(servletAdminService.findAdmin("admin", "password"));
    }
}
