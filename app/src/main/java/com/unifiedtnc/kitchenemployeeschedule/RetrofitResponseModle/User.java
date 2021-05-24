package com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle;

public class User {



    int e_id;
    String email;
    String password;
    String name;


    public User(int e_id, String email, String password, String name) {
        this.e_id = e_id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
