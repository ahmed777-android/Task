package com.example.recyclerview;

import java.io.Serializable;

public class User implements Serializable {
    private String name,phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setPhone(String pas) {
        this.phone = pas;
    }
}
