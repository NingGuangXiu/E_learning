package com.example.e_learning.User;

public class User {

    String id;
    String password;
    String email;

//    public User(String id,String password) {
//        this.id=id;
//        this.password=password;
//    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
