package com.Shambala.rest;

import com.Shambala.application.UserApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserApplication userApplication;

    public UserController(UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @PostMapping ("/creation")
    void createUser(String userName, String password){
        userApplication.createNewUser(userName, password);
    }
}
