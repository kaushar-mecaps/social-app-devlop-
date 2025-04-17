package com.kusr.socialApp.controller;

import com.kusr.socialApp.model.Comment;
import com.kusr.socialApp.request.CommentRequest;
import com.kusr.socialApp.response.CommentResponse;
import com.kusr.socialApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController  //----------------------- json & xml format accept Carta (deal Carta hai )
@RequestMapping("/comment") //------------ URL
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/")
    public void save(@RequestBody CommentRequest comment){
         commentService.saveComment(comment);
    }


    @GetMapping("/{id}")
    public CommentResponse find(@PathVariable Long id){
        return commentService.findAll(id);
    }


    @GetMapping("/")
    public List<CommentResponse> findAll(){
        return commentService.findAll();
    }

    @PutMapping("/{id}")
    public Comment commentUpd(@PathVariable Long id, @RequestBody Comment theComment){
        return commentService.CommentUpd(id, theComment);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id){
        return commentService.deleteComment(id);
    }
}
