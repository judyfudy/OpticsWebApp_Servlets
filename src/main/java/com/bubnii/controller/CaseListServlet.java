package com.bubnii.controller;

import com.bubnii.service.implementations.CaseServiceImpl;
import com.bubnii.service.implementations.GlassesServiceImpl;
import com.bubnii.service.interfaces.CaseService;
import com.bubnii.service.interfaces.GlassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/caseList")
public class CaseListServlet extends HttpServlet {
    private final CaseService caseService = new CaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cases", caseService.getAll());
        request.getRequestDispatcher("pages/casesList.jsp").forward(request, response);
    }
}
