package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute("client");
        if (client != null) {
            req.setAttribute("login", client.getLogin());
            req.setAttribute("password", client.getPassword());
            for (Cookie cookie : req.getCookies()) {
                if (cookie != null && cookie.getName() != null && cookie.getName().equals("Auth")) {
                    req.setAttribute("cookie_name", cookie.getName());
                    req.setAttribute("cookie_value", cookie.getValue());
                }
            }
        } else {
            req.setAttribute("client", "unidentified client");
            req.setAttribute("login", "login is not found");
        }
        req.getRequestDispatcher(req.getContextPath() + "/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
