package ru.itis.javalab.services;

import ru.itis.javalab.models.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    List<Comment> getAllComments(int page, int size);
    void saveComment(Comment comment);
}
