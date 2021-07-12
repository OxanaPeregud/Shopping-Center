package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DisplayDiscountStatisticsServletTest extends MockInit {

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-statistics.jsp"));

        new DisplayDiscountStatisticsServlet().doGet(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listStatistics = new ArrayList<>();
        verify(request).setAttribute("listStatistics", listStatistics);
    }
}