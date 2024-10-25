package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.UserBuilder;
import com.Shambala.models.export.CharacterExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"&#@", "Bob_Nal", "Jack!"})
    void testCreateNewUser_whenUserFirstNameIsNullOrEmptyOrHasSpecialCharacter_throwException(String firstName) {
        this.firstName = firstName;
        IllegalArgumentException userFirstNameException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User firstName should not be null, empty or contain specials characters", userFirstNameException.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"&#@", "Bob_Nal", "Jack!"})
    void testCreateNewUser_whenUserLastNameIsNullOrEmptyOrHasSpecialCharacter_throwException(String lastName) {
        this.lastName = lastName;
        IllegalArgumentException userLastNameException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User lastName should not be null, empty or contain specials characters", userLastNameException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "user",
            "user@",
            "invalid-email@.com",
            "user@domain",
            "user@domain.123",
            "user@domain..com",
            "user@domain.com.au",
            "user.name+tag@domain.co.uk"})
    void testCreateNewUser_whenUserMailIsProvided_returnEmailWithValidPattern(String email) {
        this.email = email;
        IllegalArgumentException emailException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User email pattern is incorrect", emailException.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testCreateNewUser_whenUserNickNameIsNullOrEmpty_throwException(String nickName) {
        this.nickName = nickName;
        IllegalArgumentException userNickNameException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User nickName should not be null or empty", userNickNameException.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"azerty"})
    void testCreateNewUser_whenUserPasswordIsNullOrEmptyOrToShort_throwException(String password) {
        this.password = password;
        IllegalArgumentException userPasswordException = assertThrows(IllegalArgumentException.class, () -> {
            User.fromBuilder(createTestUser());
        });
        assertEquals("User password should not be null or empty, and at least 8 characters", userPasswordException.getMessage());
    }

}
