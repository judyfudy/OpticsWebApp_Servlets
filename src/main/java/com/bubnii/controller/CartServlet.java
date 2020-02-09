package com.bubnii.controller;

import com.bubnii.entity.Person;
import com.bubnii.entity.Product;
import com.bubnii.service.implementations.PersonServiceImpl;
import com.bubnii.service.implementations.ProductServiceImpl;
import com.bubnii.service.interfaces.PersonService;
import com.bubnii.service.interfaces.ProductService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");

        try {
            List<Product> productsList = productService.getAllProductsInCart(userId);
            request.setAttribute("productList", productsList);

            Person personInfo = personService.get(userId);
            request.setAttribute("personInfo", personInfo);

            request.getRequestDispatcher("pages/cartList.jsp").forward(request, response);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int productId = Integer.parseInt(request.getParameter("productId"));

        productService.addProductToCart(userId, productId);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userId = (int) request.getSession().getAttribute("userId");

        productService.deleteFromCart(productId, userId);
    }
}
