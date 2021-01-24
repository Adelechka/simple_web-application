package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.repositories.CommentRepository;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllComments(int page, int size) {
        return commentRepository.findAll(page, size);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(Comment.builder()
                .author(comment.getAuthor())
                .text(comment.getText())
                .build());
    }
}
