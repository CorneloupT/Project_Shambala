package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import lombok.Getter;

@Getter
public class User {

    private String lastName;

    public static User fromBuilder(UserBuilder userBuilder) {
        User user = new User();
        user.lastName = userBuilder.getLastName();
        return user;
    }

}
