package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletStoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-stores")
public class ListStoresServlet extends HttpServlet {
    private final ServletStoreService servletStoreService = new ServletStoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<?> listStores = servletStoreService.getList();
        request.setAttribute("listStores", listStores);
        request.getRequestDispatcher("view/stores-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletStoreService.deleteList(request.getParameterValues("deleteStore"));
        List<?> listStores = servletStoreService.getList();
        request.setAttribute("listStores", listStores);
        request.getRequestDispatcher("view/stores-list.jsp").forward(request, response);
    }
}
