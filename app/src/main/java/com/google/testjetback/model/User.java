package com.google.testjetback.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

public class User {

    public String name;
    public String email;

    public ObservableBoolean isMark=new ObservableBoolean(false);

    public User() {
    }

    public User(String name , String email) {
        this.name = name;
        this.email=email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
