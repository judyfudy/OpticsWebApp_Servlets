package com.bubnii.controller;

import com.bubnii.service.implementations.GlassesServiceImpl;
import com.bubnii.service.implementations.WorkerServiceImpl;
import com.bubnii.service.interfaces.GlassesService;
import com.bubnii.service.interfaces.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/glassesList")
public class GlassesListServlet extends HttpServlet {
    private final GlassesService glassesService = new GlassesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("glasses", glassesService.getAll());
        request.getRequestDispatcher("pages/glassesList.jsp").forward(request, response);
    }
}
