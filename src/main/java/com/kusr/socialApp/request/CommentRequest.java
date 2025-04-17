package com.kusr.socialApp.request;

import java.time.LocalDate;

public class CommentRequest {
    private String commentString;
    private LocalDate commentedAt;
    private Long postId;

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }


    public LocalDate getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDate commentedAt) {
        this.commentedAt = commentedAt;
    }
}
