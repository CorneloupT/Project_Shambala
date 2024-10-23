package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;

    @BeforeEach
    void setUp() {
        lastName = "Doe";
        firstName = "John";
        email = "john.doe@test.com";
        nickName = "alpha";
        password = "123azer";

    }

    private record TestBuilder(String getLastName, String getFirstName, String getEmail, String getNickName, String getPassword) implements UserBuilder {
    }

    private UserBuilder createTestUser() {
        return new TestBuilder(lastName, firstName, email, nickName, password);
    }

    @Test
    void should_create_user_from_builder() {
        User user = User.fromBuilder(new TestBuilder("Morris", "John", "jolly.doe@test.com", "alpha", "123azer"));
        assertNotNull(user);
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidLastName() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(lastName, userTest.getLastName());
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidFirstName() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(firstName, userTest.getFirstName());
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidEmail() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(email, userTest.getEmail());
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidNickName() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(nickName, userTest.getNickName());
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidPassword() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(password, userTest.getPassword());
    }


}
