package com.example.commentapi.controller;

import com.example.commentapi.model.Comment;
import com.example.commentapi.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddComment() throws Exception {
        UUID issueId = UUID.randomUUID();
        Comment comment = new Comment();
        comment.setAuthor("john");
        comment.setMessage("hello");
        comment.setIssueId(issueId);

        Mockito.when(service.addComment(Mockito.any())).thenReturn(comment);

        mockMvc.perform(post("/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("john"));
    }

    @Test
    void testGetByAuthor() throws Exception {
        Comment comment = new Comment();
        comment.setAuthor("john");
        comment.setMessage("hello");
        comment.setIssueId(UUID.randomUUID());

        Mockito.when(service.getCommentsByAuthor("john")).thenReturn(Collections.singletonList(comment));

        mockMvc.perform(get("/comments?author=john"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("john"));
    }
}
