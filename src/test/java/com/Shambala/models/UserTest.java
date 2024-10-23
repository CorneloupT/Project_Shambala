package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.UserBuilder;
import com.Shambala.models.export.CharacterExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;
    private List<Character> characterList;

    @BeforeEach
    void setUp() {
        lastName = "Doe";
        firstName = "John";
        email = "john.doe@test.com";
        nickName = "alpha";
        password = "123azer";
        characterList = new ArrayList<>();

        CharacterBuilder mockCharacterBuilder = mock(CharacterBuilder.class);
        when(mockCharacterBuilder.getName()).thenReturn("Archie");
        when(mockCharacterBuilder.getRace()).thenReturn(Race.YSGANDIEN);
        when(mockCharacterBuilder.getPlayerClass()).thenReturn("Mage");
        when(mockCharacterBuilder.getGlobalLevel()).thenReturn(4);
        when(mockCharacterBuilder.getExperience()).thenReturn(1200);
        when(mockCharacterBuilder.getClassLevel()).thenReturn(4);
        when(mockCharacterBuilder.getClassExperience()).thenReturn(900);
        when(mockCharacterBuilder.getBackground()).thenReturn("Hello everybody");

        Character character1 = Character.from(mockCharacterBuilder);
        characterList.add(character1);
    }

    private record TestBuilder(
            String getLastName,
            String getFirstName,
            String getEmail,
            String getNickName,
            String getPassword,
            List<Character> getCharacterList) implements UserBuilder {
    }

    private UserBuilder createTestUser() {
        return new TestBuilder(lastName, firstName, email, nickName, password, characterList);
    }

    @Test
    void should_create_user_from_builder() {
        User user = User.fromBuilder(new TestBuilder(
                "Morris",
                "John",
                "jolly.doe@test.com",
                "alpha",
                "123azer",
                characterList
                ));
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

    @Test
    void testCreateNewUser_whenUserIsProvided_returnListOfCharacter() {
        User userTest =  User.fromBuilder(createTestUser());
        assertEquals(characterList, userTest.getCharacterList());
    }

    @Test
    void testCreateNewUser_whenUserMailIsProvided_returnEmailWithValidPattern() {
        IllegalArgumentException emailException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User email pattern is incorrect", emailException.getMessage());
    }

}
