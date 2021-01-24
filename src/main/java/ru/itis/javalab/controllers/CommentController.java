package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.services.CommentService;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public String getCommentsPage(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "size", required = false) Integer size,
                               Model model) {
        if (page != null && size != null) {
            model.addAttribute("comments", commentService.getAllComments(page, size));
        } else {
            model.addAttribute("comments", commentService.getAllComments());
        }
        return "comments_page";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String addUser(Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/comment";
    }
}
