package com.bubnii.controller;

import com.bubnii.entity.Person;
import com.bubnii.service.implementations.PersonServiceImpl;
import com.bubnii.service.interfaces.PersonService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        Person personInfo = null;
        try {
           personInfo = personService.get(userId);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("personInfo", personInfo);
        request.getRequestDispatcher("pages/profile.jsp").forward(request, response);
    }
}
