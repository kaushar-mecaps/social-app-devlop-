package com.kusr.socialApp.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="comment_id")
    private long commentId;

    @Column(name="comment_string")
    private String commentString;

   @ManyToOne
    private Post postId;

    @ManyToOne
    private User author;

    @Column(name="commented_at")
    private LocalDate commentedAt;

    public Comment() {
    }


    public Comment(String commentString, Post postId, User author, LocalDate commentedAt) {
        this.commentString = commentString;
        this.postId = postId;
        this.author = author;
        this.commentedAt = commentedAt;
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

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDate getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDate commentedAt) {
        this.commentedAt = commentedAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentString='" + commentString + '\'' +
                ", postId=" + postId +
                ", author=" + author +
                ", commentedAt=" + commentedAt +
                '}';
    }
}


