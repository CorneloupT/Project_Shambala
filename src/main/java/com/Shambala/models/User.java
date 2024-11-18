package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import com.Shambala.models.export.UserExport;
import lombok.Getter;

import java.util.List;

@Getter
public class User {

    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;
    private List<Character> characterList;

    public static User fromBuilder(UserBuilder userBuilder) {
        User user = new User();
        user.id = userBuilder.getId();
        user.lastName = userBuilder.getLastName();
        user.firstName = userBuilder.getFirstName();
        user.email = userBuilder.getEmail();
        user.nickName = userBuilder.getNickName();
        user.password = userBuilder.getPassword();
        user.characterList = userBuilder.getCharacterList();
        user.verifyUserNames();
        user.verifyUserEmailIsCorrect();
        user.verifyUserNickNameIsCorrect();
        user.verifyUserPasswordIsCorrect();
        return user;
    }

    public void verifyUserNames() {
        verifyName(firstName, "User firstName");
        verifyName(lastName, "User lastName");
    }
    private void verifyName(String name, String nameField) {
        if (name == null || name.isEmpty() || !name.matches("^[a-zA-Z0-9 ]+$")) {
            throw new IllegalArgumentException(nameField + " should not be null, empty or contain specials characters");
        }
    }
    private void verifyUserEmailIsCorrect() {

        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";

        if (!email.matches(emailPattern)) {
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

    public void exportTo(UserExport export) {
        export.setLastName(lastName);
        export.setFirstName(firstName);
        export.setEmail(email);
        export.setNickName(nickName);
        export.getPassword(password);
        export.getListCharacter(characterList);
    }
}
