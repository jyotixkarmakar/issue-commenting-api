package com.example.commentapi.service;

import com.example.commentapi.model.Comment;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    private final CommentService service = new CommentService();

    @Test
    void addComment_shouldStoreCorrectly() {
        Comment c = new Comment();
        c.setAuthor("alice");
        c.setMessage("test");
        c.setIssueId(UUID.randomUUID());

        Comment saved = service.addComment(c);
        assertEquals("alice", saved.getAuthor());
        assertEquals(1, service.getAllComments().size());
    }
}
