package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class User {

    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;
    private List<Character> characterList;

    public static User fromBuilder(UserBuilder userBuilder) {
        User user = new User();
        user.lastName = userBuilder.getLastName();
        user.firstName = userBuilder.getFirstName();
        user.email = userBuilder.getEmail();
        user.nickName = userBuilder.getNickName();
        user.password = userBuilder.getPassword();
        user.characterList = userBuilder.getCharacterList();
        user.verifyUserFirstNameIsCorrect();
        user.verifyUserLastNameIsCorrect();
        user.verifyUserEmailIsCorrect();
        user.verifyUserNickNameIsCorrect();
        user.verifyUserPasswordIsCorrect();
        return user;
    }

    private void verifyUserFirstNameIsCorrect() {
        if (firstName == null || firstName.isEmpty() || !firstName.matches("^[a-zA-Z0-9 ]+$")) {
            throw new IllegalArgumentException("User firstName should not be null, empty or contain specials characters");
        }
    }

    private void verifyUserLastNameIsCorrect() {
        if (lastName == null || lastName.isEmpty() || !lastName.matches("^[a-zA-Z0-9 ]+$")) {
            throw new IllegalArgumentException("User lastName should not be null, empty or contain specials characters");
        }
    }

    private void verifyUserEmailIsCorrect() {

        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";

        if (!email.matches(emailPattern) || email == null) {
            throw new IllegalArgumentException("User email pattern is incorrect");
        }
    }

    private void verifyUserNickNameIsCorrect() {
        if (nickName == null || nickName.isEmpty()) {
            throw new IllegalArgumentException("User nickName should not be null or empty");
        }
    }

    private void verifyUserPasswordIsCorrect() {
        if (password == null || password.isEmpty() || password.length() < 8) {
            throw  new IllegalArgumentException("User password should not be null or empty, and at least 8 characters");
        }
    }

}
