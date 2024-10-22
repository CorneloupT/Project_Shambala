package com.Shambala.models;

import com.Shambala.models.builder.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private String lastName;

    @BeforeEach
    void setUp() {
        lastName = "Doe";
    }

    private record TestBuilder(String getLastName) implements UserBuilder {
    }

    private UserBuilder createTestUser() {
        return new TestBuilder(lastName);
    }

    @Test
    void should_create_user_from_builder() {
        User user = User.fromBuilder(new TestBuilder("Morris"));
        assertNotNull(user);
    }

    @Test
    void testCreateNewUser_whenUserDetailsProvided_returnValidLastName() {
        User userTest = User.fromBuilder(createTestUser());
        assertEquals(lastName, userTest.getLastName());
    }


}
