package com.kusr.socialApp.response;

import com.kusr.socialApp.model.Comment;
import com.kusr.socialApp.model.Post;
import com.kusr.socialApp.model.User;

import java.time.LocalDate;

public class CommentResponse {

    private long commentId;
    private String commentString;
    private LocalDate commentedAt;
    private PostResponse postId;

    public CommentResponse(Comment obj) {
        this.commentId = obj.getCommentId();
        this.commentString = obj.getCommentString();
        this.commentedAt = obj.getCommentedAt();
        this.postId = new PostResponse(obj.getPostId());
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public PostResponse getPostId() {
        return postId;
    }

    public void setPostId(PostResponse postId) {
        this.postId = postId;
    }

    public LocalDate getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDate commentedAt) {
        this.commentedAt = commentedAt;
    }
}
