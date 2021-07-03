package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.SearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-shop")
public class SearchShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String clientRequest = request.getParameter("clientRequest");
        List<?> listShops = SearchUtil.shopSearch(clientRequest);
        request.setAttribute("listShops", listShops);
        request.getRequestDispatcher("view/search-shop.jsp").forward(request, response);
    }
}
