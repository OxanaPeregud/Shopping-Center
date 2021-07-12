package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DisplayAllDiscountsServletTest {

    @Test
    void doGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        List<?> listDiscounts = new ArrayList<>();
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        new DisplayAllDiscountsServlet().doGet(request, response);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-discounts.jsp"));
        verify(requestDispatcher).forward(request, response);
        verify(request).setAttribute("listDiscounts", listDiscounts);
    }
}
