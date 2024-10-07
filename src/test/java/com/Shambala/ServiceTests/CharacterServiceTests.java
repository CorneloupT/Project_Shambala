package com.Shambala.ServiceTests;

import com.Shambala.Enum.Race;
import com.Shambala.Service.CharacterService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterServiceTests {

    @Test
    public void characterName_ShouldNotBeEmpty() {
        String name = "Tom";
        boolean validName = CharacterService.characterHasAValidName(name);

        assertTrue(validName);
    }

    @Test
    public void characterName_ShouldNotBeNull() {
        String name = "Efrim";
        boolean nameNotNull = CharacterService.characterHasAValidName(name);

        assertTrue(nameNotNull);
    }

    @Test
    public void characterName_ShouldNotContainSpecialCharacters() {
        String validName = "Efrim";
        assertTrue(CharacterService.characterHasAValidName(validName));

        String validNameWithSpace = "Efrim Nal";
        assertTrue(CharacterService.characterHasAValidName(validNameWithSpace));

        String nameWithSpecialChar = "Efrim@Nal";
        assertFalse(CharacterService.characterHasAValidName(nameWithSpecialChar));

        String nameWithNumber = "Efrim123";
        assertFalse(CharacterService.characterHasAValidName(nameWithNumber));

        String nameWithMultipleSpecialChars = "Efrim@#Nal!";
        assertFalse(CharacterService.characterHasAValidName(nameWithMultipleSpecialChars));
    }

    @Test
    public void characterRace_ShouldBeInTheEnumListOfRace() {
        Set<String> expectedRaces = Set.of("KHAZAD", "YSGANDIEN", "YSGANDIENNE");

        Set<String> actualRaces = CharacterService.getAllRaces();

        assertEquals(expectedRaces, actualRaces);

    }
}
