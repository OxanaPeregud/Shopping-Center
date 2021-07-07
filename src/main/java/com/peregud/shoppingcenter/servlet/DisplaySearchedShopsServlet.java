package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.SearchActualDiscountUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display-searched-shops")
public class DisplaySearchedShopsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<?> listShops = SearchActualDiscountUtil.selectShopsWithActualDiscount();
        request.setAttribute("listShops", listShops);
        request.getRequestDispatcher("view/display-shops.jsp").forward(request, response);
    }
}
