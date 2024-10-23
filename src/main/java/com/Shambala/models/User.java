package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import lombok.Getter;

@Getter
public class User {

    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;

    public static User fromBuilder(UserBuilder userBuilder) {
        User user = new User();
        user.lastName = userBuilder.getLastName();
        user.firstName = userBuilder.getFirstName();
        user.email = userBuilder.getEmail();
        user.nickName = userBuilder.getNickName();
        user.password = userBuilder.getPassword();
        return user;
    }

}
