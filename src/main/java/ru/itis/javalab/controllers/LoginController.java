package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "login_page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String login, String hashPassword) {
        if (usersService.containsUser(login, hashPassword)) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
