package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Store;
import com.peregud.shoppingcenter.service.ServletStoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-store")
public class EditStoreServlet extends HttpServlet {
    private final ServletStoreService servletStoreService = new ServletStoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Store store = servletStoreService.getById(id);
        request.setAttribute("store", store);
        request.getRequestDispatcher("view/store-form.jsp").forward(request, response);
    }
}
