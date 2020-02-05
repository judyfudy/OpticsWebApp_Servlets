package com.bubnii.controller;

import com.bubnii.entity.Person;
import com.bubnii.enums.PersonType;
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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String passwordToHash = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try {

            String securePassword = HashPasswordUtil.hashPassword(passwordToHash);
            PersonService personService = new PersonServiceImpl();
            Person person = personService.getPersonByCredentials(username);

            if (person.getUsername() == null) {

                person = new Person(username, securePassword, firstName, lastName, PersonType.USER);
                personService.add(person);
                person = personService.getPersonByCredentials(username);

                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                session.setAttribute("userId", person.getIdPerson());
                System.out.println("УСПІШНО ЗАРЕЄСТРОВАНО");

                response.sendRedirect("/");
            } else {
                response.sendError(403);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }
}
