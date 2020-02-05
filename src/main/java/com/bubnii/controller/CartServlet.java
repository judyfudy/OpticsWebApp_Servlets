package com.bubnii.controller;

import com.bubnii.entity.Product;
import com.bubnii.service.implementations.ProductServiceImpl;
import com.bubnii.service.interfaces.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        List<Product> productsList = productService.getAllProductsInCart(userId);
        request.setAttribute("productList", productsList);
        request.getRequestDispatcher("pages/cartList.jsp").forward(request,response);

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
