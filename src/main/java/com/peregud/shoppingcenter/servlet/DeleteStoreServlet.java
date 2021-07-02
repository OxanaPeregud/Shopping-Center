package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletStoreService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-store")
public class DeleteStoreServlet extends HttpServlet {
    private final ServletStoreService servletStoreService = new ServletStoreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        servletStoreService.delete(id);
        response.sendRedirect(request.getContextPath() + "/list-stores");
    }
}
