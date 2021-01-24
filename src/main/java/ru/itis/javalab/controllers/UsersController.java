package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//public class UsersController implements Controller {
//
//    @Autowired
//    private UsersService usersService;
//
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        if (httpServletRequest.getMethod().equals("GET")) {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.addObject("users", usersService.getAllUsers());
//            modelAndView.setViewName("users_view");
//            //modelAndView.setViewName("redirect:/users");
//            return modelAndView;
//        }
//        return null;
//    }
//}

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    //    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public ModelAndView getUsersPage() {
//        //public ModelAndView getUsersPage(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users_view");
//        modelAndView.addObject("users", usersService.getAllUsers());
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public ModelAndView addUser(UserDto user) {
//        //public ModelAndView getUsersPage(HttpServletRequest request, HttpServletResponse response) {
//        usersService.addUser(user);
//        return new ModelAndView("redirect:/users");
//    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "size", required = false) Integer size,
                               Model model) {
        if (page != null && size != null) {
            model.addAttribute("users", usersService.getAllUsers(page, size));
        } else {
            model.addAttribute("users", usersService.getAllUsers());
        }
        return "users_view";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(UserDto user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/{user-id}", produces = "application/json")
    @ResponseBody
    public UserDto getUser(@PathVariable("user-id") Long userId) {
        return usersService.getUser(userId);
    }

    @RequestMapping(value = "/users/json", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDto> addUserFromJson(@RequestBody UserDto user) {
        usersService.addUser(user);
        return usersService.getAllUsers();
    }
}