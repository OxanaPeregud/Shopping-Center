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
import static org.mockito.Mockito.verify;

class DisplayAllShopsServletTest {

    @Test
    void doGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        List<?> listShops = new ArrayList<>();
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        new DisplayAllShopsServlet().doGet(request, response);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-shops.jsp"));
        verify(requestDispatcher).forward(request, response);
        verify(request).setAttribute("listShops", listShops);
    }
}
