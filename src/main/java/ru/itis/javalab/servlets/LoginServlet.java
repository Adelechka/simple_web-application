package ru.itis.javalab.servlets;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.javalab.models.Client;
import ru.itis.javalab.services.ClientService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private ClientService clientService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.clientService = (ClientService) servletContext.getAttribute("clientsService");
        this.passwordEncoder = (PasswordEncoder) servletContext.getAttribute("passwordEncoder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("client");
        }
        req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<Client> clients = clientService.getByData(login, password);

        if (clients != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("client", clients.get(0));
            Client client = clients.get(0);
            Cookie cookie = new Cookie("Auth", client.getUuid());
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}
