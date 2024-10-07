package com.Shambala.ServiceTests;

import com.Shambala.Service.CharacterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        boolean nameNotNull = CharacterService.characterHasNotANullName(name);

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

        // Cas invalide : nom avec plusieurs caractères spéciaux
        String nameWithMultipleSpecialChars = "Efrim@#Nal!";
        assertFalse(CharacterService.characterHasAValidName(nameWithMultipleSpecialChars));
    }
}
