package com.kusr.socialApp.controller;

import com.kusr.socialApp.model.User;
import com.kusr.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//----------------------------------------------------------------------------------------------------------------

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User save(@RequestBody User theUser){
    return userService.saveUser(theUser);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable Long id){
        return userService.findAll(id);
    }

    @PutMapping("/{id}")
    public User userUpdate(@PathVariable Long id, @RequestBody User request){
        return userService.userUpdate(id, request);
    }

    @DeleteMapping("/{id}")
    public String userDelete(@PathVariable Long id){
        return userService.userDelete(id);
    }


    @GetMapping("/")
    public List<User> findAll(){
       return userService.findAll();
    }
}
