package com.peregud.shoppingcenter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("view/login-operations.jsp").include(request, response);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name.equals("admin") && password.equals("1234")) {
            response.sendRedirect(request.getContextPath() + "/list-shops");
        } else {
            out.print("Incorrect username or password!");
            request.getRequestDispatcher("view/admin-login.jsp").include(request, response);
        }
        out.close();
    }
}
