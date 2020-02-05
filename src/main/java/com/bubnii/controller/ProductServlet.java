package com.bubnii.controller;

import com.bubnii.entity.Product;
import com.bubnii.entity.ProductType;
import com.bubnii.service.implementations.ProductServiceImpl;
import com.bubnii.service.interfaces.ProductService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProductType> productTypes = productService.getAllTypesOfProducts();
        request.setAttribute("productTypes", productTypes);

        request.getRequestDispatcher("pages/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeId = Integer.parseInt(request.getParameter("typeId"));

        List<Product> productList = productService.getProductsByType(typeId);

        request.setAttribute("products", productList);
        String json = new Gson().toJson(productList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
