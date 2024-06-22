package com.example.restaurant.restaurantapp1;

public class User {
    private String _inn;
    private String _password;
    public User(String phone, String password){
        _inn = phone;
        _password = password;
    }

    public String get_inn() {
        return _inn;
    }

    public String get_password() {
        return _password;
    }
}

