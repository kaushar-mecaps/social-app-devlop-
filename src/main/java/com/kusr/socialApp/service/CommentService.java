package com.kusr.socialApp.service;

import com.kusr.socialApp.model.Comment;
import com.kusr.socialApp.model.Post;
import com.kusr.socialApp.repository.CommentRepositiry;
import com.kusr.socialApp.repository.PostRepository;
import com.kusr.socialApp.request.CommentRequest;
import com.kusr.socialApp.response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepositiry commentRepositiry;
    private CommentResponse commentResponse;
    private PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepositiry commentRepositiry,PostRepository postRepository) {
        this.commentRepositiry = commentRepositiry;
        this.postRepository = postRepository;
    }

    public void saveComment(CommentRequest request){
        Comment commentObj = new Comment();

       Post postObj = postRepository.findById(request.getPostId()).orElseThrow(() ->
               new RuntimeException("id not found"));

        commentObj.setCommentString(request.getCommentString());
        commentObj.setPostId(postObj);
        commentObj.setCommentedAt(request.getCommentedAt());
        commentObj.setAuthor(postObj.getUser());
        commentRepositiry.save(commentObj);

    }


    public CommentResponse findAll(Long id){
        return new CommentResponse(commentRepositiry.findById(id).orElseThrow(()
                -> new RuntimeException("id not found")));
    }


    public List<CommentResponse> findAll(){
        List<Comment> all =  commentRepositiry.findAll();
        return all.stream() .map(CommentResponse::new).toList();
    }


    public Comment CommentUpd(Long id , Comment request){
        Comment theComment = commentRepositiry.findById(id).orElseThrow(()->
                new RuntimeException("Id Is Not found"));

        if(request.getCommentString()!=null){
             theComment.setCommentString(request.getCommentString());

        }

        return commentRepositiry.save(theComment);
    }


    public String deleteComment(Long id){
       if(commentRepositiry.existsById(id)){
           commentRepositiry.deleteById(id);
           return ("Delete Successfully");
       }

       else{
           return "id is not found";
       }
    }
}
