package com.bubnii.controller;

import com.bubnii.service.implementations.WorkerServiceImpl;
import com.bubnii.service.interfaces.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/workerList")
public class WorkerListServlet extends HttpServlet {
    private final WorkerService workerService = new WorkerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("workers", workerService.getAll());
        request.getRequestDispatcher("pages/workerList.jsp").forward(request, response);
    }


}
