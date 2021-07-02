package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.converter.ConverterImpl;
import com.peregud.shoppingcenter.model.Store;
import com.peregud.shoppingcenter.service.ServletStoreService;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-store")
public class UpdateStoreServlet extends HttpServlet {
    private final ServletStoreService servletStoreService = new ServletStoreService();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Store store = (Store) ConverterImpl.getConverter(Store.class).convert(request);
        servletStoreService.save(store);
        response.sendRedirect(request.getContextPath() + "/list-stores");
    }
}
