package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/registration")
    public String getRegistrationPage(Model model) {
        return "registration_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(User user) {
        usersService.saveUser(user);
        return "redirect:/";
    }
}
