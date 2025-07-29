package com.example.commentapi.service;

import com.example.commentapi.model.Comment;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final Map<String, Comment> commentStore = new ConcurrentHashMap<>();

    public Comment addComment(Comment comment) {
        commentStore.put(comment.getId(), comment);
        return comment;
    }

    public List<Comment> getCommentsByIssueId(UUID issueId) {
        return commentStore.values().stream()
                .filter(c -> c.getIssueId().equals(issueId))
                .collect(Collectors.toList());
    }

    public List<Comment> getCommentsByAuthor(String author) {
        return commentStore.values().stream()
                .filter(c -> c.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Comment> getAllComments() {
        return new ArrayList<>(commentStore.values());
    }
}
