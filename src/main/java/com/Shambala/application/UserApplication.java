package com.Shambala.application;

import com.Shambala.models.User;
import com.Shambala.models.UserPort;
import org.springframework.stereotype.Service;

@Service
public class UserApplication {

    private final UserPort userPort;

    public UserApplication(UserPort userPort) {
        this.userPort = userPort;
    }

    public void createNewUser(String username, String password) {
        User newUser = new User(); // buidler

        userPort.saveNewUser(newUser);
    }
}
