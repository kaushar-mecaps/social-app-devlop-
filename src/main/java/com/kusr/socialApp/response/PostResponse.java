package com.kusr.socialApp.response;

import com.kusr.socialApp.model.Post;
import com.kusr.socialApp.model.User;

import java.time.LocalDate;

public class PostResponse {

    private long postId;
    private String text;
    private LocalDate postedAt;
    private UserResponse user;

    public PostResponse(Post obj) {
        this.postId = obj.getPostId();
        this.text = obj.getText();
        this.postedAt = obj.getPostedAt();
        this.user = new UserResponse(obj.getUser());
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
