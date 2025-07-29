package com.example.commentapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public class Comment {
    private final String id = UUID.randomUUID().toString();

    @NotNull
    private UUID issueId;

    @NotBlank
    private String author;

    @NotBlank
    private String message;

    private final Instant createdAt = Instant.now();

    public String getId() { return id; }

    public UUID getIssueId() { return issueId; }
    public void setIssueId(UUID issueId) { this.issueId = issueId; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getCreatedAt() { return createdAt; }
}
