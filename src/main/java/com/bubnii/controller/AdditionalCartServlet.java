package com.bubnii.controller;

import com.bubnii.entity.Product;
import com.bubnii.service.implementations.ProductServiceImpl;
import com.bubnii.service.interfaces.ProductService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@WebServlet("/emptyCart")
public class AdditionalCartServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");

        productService.clearCart(userId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        List<Product> productList = productService.getAllProductsInCart(userId);

        List<String> productsInfo = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            productsInfo.add(i, "Назва: " + productList.get(i).getName() + " | " + "Модель: "
            + productList.get(i).getModel() + " | " + "Ціна: " + productList.get(i).getPrice());
        }

        StringBuilder orderInfo = new StringBuilder();
        for (String s : productsInfo) {
            orderInfo.append(s).append("\n");
        }

        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        orderInfo.append("Загальна сума до оплати: ").append(totalPrice).append(" грн.");

        long orderNumber = (long) (10000 + Math.random() * 10000);

        final Properties properties = new Properties();
        properties.load(AdditionalCartServlet.class.getClassLoader().getResourceAsStream("mail.properties"));

        String email = request.getParameter("email");

        try {
            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress("bubniyo@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Дякуємо за замовлення!");
            message.setText("№ замовлення: " + orderNumber + "\n" +
                    "Дата замовлення: " + new Date() + "\n" +
                    "Реквізити оплати: 5375 4141 0550 2925\n" + orderInfo);

            Transport tr = mailSession.getTransport();
            tr.connect(null, "567tyu567tyua");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
            productService.clearCart(userId);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
