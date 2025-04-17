package com.kusr.socialApp.response;

import com.kusr.socialApp.model.User;

public class UserResponse {
    private long userId;
    private String userName;
    private String email;


    public UserResponse(User obj) {
         this.userId = obj.getUserId();
        this.userName = obj.getUserName();
        this.email = obj.getEmail();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
