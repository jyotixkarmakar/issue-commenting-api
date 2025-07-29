package com.example.commentapi.controller;

import com.example.commentapi.model.Comment;
import com.example.commentapi.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@Valid @RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping
    public List<Comment> getComments(
            @RequestParam(required = false) UUID issueId,
            @RequestParam(required = false) String author
    ) {
        if (issueId != null) return commentService.getCommentsByIssueId(issueId);
        if (author != null) return commentService.getCommentsByAuthor(author);
        return commentService.getAllComments();
    }
}
