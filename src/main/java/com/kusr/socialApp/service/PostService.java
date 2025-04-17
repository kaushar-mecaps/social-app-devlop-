package com.kusr.socialApp.service;

import com.kusr.socialApp.model.Comment;
import com.kusr.socialApp.model.Post;
import com.kusr.socialApp.model.User;
import com.kusr.socialApp.repository.CommentRepositiry;
import com.kusr.socialApp.repository.PostRepository;
import com.kusr.socialApp.repository.UserRepository;
import com.kusr.socialApp.request.PostRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {


    private PostRepository postRepository;
    private  CommentRepositiry commentRepositiry;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }




    public void save(PostRequest thePost){
        Post postObj = new Post();

        User userObj = userRepository.findById(thePost.getUserId()).orElseThrow(() ->
                new RuntimeException("id not found"));

        postObj.setUser(userObj);
        postObj.setText(thePost.getText());
        postObj.setPostedAt(thePost.getPostedAt());

        postRepository.save(postObj);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findAll(Long id){
        return postRepository.findById(id).orElseThrow(() ->new RuntimeException("Id not found"));
    }

    public Post postUpdate(Long id,Post request){
        Post thePost = postRepository.findById(id).orElseThrow(()
                ->new RuntimeException("Id Not found"));





        if(request.getPostedAt() !=  null){
            thePost.setPostedAt(request.getPostedAt());

        }
        if(request.getText() != null){
            thePost.setText(request.getText());
        }
        if(request.getUser() != null){
            thePost.setUser(request.getUser());

        }
        return postRepository.save(thePost);
    }



    public String postDelete(Long id){
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
            return ("Delete Successfully");
        }
        else {
            return"id is not found";
        }
    }
}
