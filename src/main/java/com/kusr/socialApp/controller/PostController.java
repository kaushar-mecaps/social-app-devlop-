package com.kusr.socialApp.controller;

import com.kusr.socialApp.model.Post;
import com.kusr.socialApp.request.PostRequest;
import com.kusr.socialApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }



    @PostMapping("/")
    public void save(@RequestBody PostRequest thePost){
        postService.save(thePost);
    }



    @GetMapping("/")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post find(@PathVariable Long id){
        return postService.findAll(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post thePost){
        return postService.postUpdate(id,thePost);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        return postService.postDelete(id);
    }


}
