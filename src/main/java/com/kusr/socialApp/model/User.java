package com.kusr.socialApp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

//-------------------------------------------------------------------------------------------------------------

@Entity              //Table create ,Create row & column
@Table(name="user")
public class User {
    @Id       //(spesify the primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // (Automatically generate ID)

    @Column(name="user_id")
    private long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String  password;

    @Column(name="email")
    private String email;

//    -----------------------------------------------------------------------------------------------------------
//                                    ************** Mapped Post ******************
//                                   ( UserId delete Karney per post bhi delete ho jaega )

    @OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Post> post = new ArrayList<>();

    //---------------------------------------------------------------------------------------------------------------



//                                      ******* Contractor ***********

    public User() {

    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

//-------------------------------------------------------------------------------------------------------------




//                                    ********** Getter and Setter **********

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
//    ------------------------------------------------------------------------------------------------------------

