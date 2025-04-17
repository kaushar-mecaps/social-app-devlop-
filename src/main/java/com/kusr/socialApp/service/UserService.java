package com.kusr.socialApp.service;

import com.kusr.socialApp.model.User;
import com.kusr.socialApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


   private UserRepository userRepository;
    @Autowired


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(User theUser){
        return userRepository.save(theUser);
    }

    public User findAll(Long id){
        return userRepository.findById(id).orElseThrow(() ->new RuntimeException("not found"));
    }

    public User userUpdate(Long id, User request){

        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("id not found"));

        if(request.getUserName()!=null){
            user.setUserName(request.getUserName());
        }

        if(request.getEmail()!=null){
         user.setEmail(request.getEmail());
        }

        if(request.getPassword()!=null){
         user.setPassword(request.getPassword());
        }

        return userRepository.save(user);
    }

    public String userDelete(Long id){
        if(userRepository.existsById(id)){
         userRepository.deleteById(id);
         return  "deleted successfully";
        }
        else {
            return "id not found";
        }
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }





}
