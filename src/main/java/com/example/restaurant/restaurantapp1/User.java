package com.example.restaurant.restaurantapp1;

public class User {
    private Integer id;
    private String _password;
    public User(Integer id){
        this.id = id;
    }

    public Integer get_id() {
        return this.id;
    }
}