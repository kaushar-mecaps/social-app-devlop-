package com.kusr.socialApp.repository;

import com.kusr.socialApp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositiry extends JpaRepository<Comment,Long> {
}
