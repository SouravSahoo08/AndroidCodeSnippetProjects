package com.example.logindemo;

public class UserHelperClass {
    String username,password,id;

    public UserHelperClass() {
    }

    public UserHelperClass(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
