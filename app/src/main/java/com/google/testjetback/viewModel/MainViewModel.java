package com.google.testjetback.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.testjetback.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<User>>user=new MutableLiveData<>();



    MainNavigator navigator;



    public  MutableLiveData<List<User>> getUser() {
        setUser();
        return user;
    }

    public void setNavigator(MainNavigator navigator) {
        this.navigator = navigator;
    }

    public void setUser() {

        List<User>users=new ArrayList<>();

        users.add(new User("shaimaa salama","www.shasho555@gmail.com"));
        users.add(new User("shaimaa salama","www.shasho555@gmail.com"));
        users.add(new User("shaimaa salama","www.shasho555@gmail.com"));
        this.user.setValue(users);
    }

    public void itemClick(User user){

        navigator.onItemClick(user);
    }
/*
#Button
    public void UpdateUser() {
        User user=new User();

        user.name="Update shaimaa";
        user.email="update@gmail.com";

        this.user.setValue(user);
    }*/
}

