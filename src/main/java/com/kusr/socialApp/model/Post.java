package com.kusr.socialApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private long postId;

    @Column(name="text")
    private String text;

    @Column(name="posted_at")
    private LocalDate postedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

//    ___________________________________________________________________________________________________________
//    Delete PostId Throw All CommentId Delete
    @OneToMany(mappedBy = "postId",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

//    ______________________________________________________________________________________________________________


    public Post() {

    }

    public Post(String text, LocalDate postedAt, User user) {
        this.text = text;
        this.postedAt = postedAt;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    ------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", text='" + text + '\'' +
                ", postedAt=" + postedAt +
                ", user=" + user +
                '}';
    }
}
