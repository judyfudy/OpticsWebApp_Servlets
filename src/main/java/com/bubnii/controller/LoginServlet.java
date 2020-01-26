package com.bubnii.controller;

import com.bubnii.entity.Person;
import com.bubnii.service.implementations.PersonServiceImpl;
import com.bubnii.service.interfaces.PersonService;
import com.bubnii.utils.HashPasswordUtil;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getSession(false).getAttribute("user"));
        request.getRequestDispatcher("pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String passwordToHash = request.getParameter("password");

        try {
            PersonService personService = new PersonServiceImpl();
            Person person = personService.getPersonByCredentials(username);

            if (person.getUsername() != null) {

                boolean validPassword = HashPasswordUtil.checkPassword(passwordToHash, person.getPassword());

                if (validPassword) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", username);
                    session.setAttribute("userId", person.getIdPerson());
                    System.out.println("successful login");
                } else {
                    response.sendError(401);
                }
            } else {
                response.sendError(403);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
