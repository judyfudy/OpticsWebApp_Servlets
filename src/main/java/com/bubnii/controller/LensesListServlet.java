package com.bubnii.controller;

import com.bubnii.service.implementations.GlassesServiceImpl;
import com.bubnii.service.implementations.LensesServiceImpl;
import com.bubnii.service.interfaces.GlassesService;
import com.bubnii.service.interfaces.LensesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lensesList")
public class LensesListServlet extends HttpServlet {
    private final LensesService lensesService = new LensesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lenses", lensesService.getAll());
        request.getRequestDispatcher("pages/lensesList.jsp").forward(request, response);
    }
}
