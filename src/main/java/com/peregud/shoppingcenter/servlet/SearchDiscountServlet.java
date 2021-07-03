package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.SearchUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-discount")
public class SearchDiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int minimumDiscount = Integer.parseInt(request.getParameter("minimumDiscount"));
        List<?> listShops = SearchUtil.discountSearch(minimumDiscount);
        request.setAttribute("listShops", listShops);
        request.getRequestDispatcher("view/search-discount.jsp").forward(request, response);
    }
}
