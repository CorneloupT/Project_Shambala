package com.Shambala.ServiceTests;

import com.Shambala.Service.ServiceImpl.CharacterServiceImpl;
import com.Shambala.Enum.Race;
import com.Shambala.Service.CharacterService;
import com.Shambala.models.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    private CharacterService characterService;

    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;


    @BeforeEach
    void setUp() {
        characterService = new CharacterServiceImpl();
        name = "Efrim";
        race = Race.YSGANDIEN;
        playerClass = "Pyromancien";
        globalLevel = 5;
        experience = 1500;
        classLevel = 6;
        classExperience = 2000;
        background = "Bonjour";
    }

    private Character createTestCharacter() {
        return characterService.createNewCharacter(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnCharacter(){
        //Act
        Character characterTest = createTestCharacter();

        //Assert
        assertNotNull(characterTest, "The createNewCharacter method should not return null");
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameName() {
        Character characterTest = createTestCharacter();
        assertEquals(name, characterTest.getName());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSamePlayerClass() {
        Character characterTest = createTestCharacter();
        assertEquals(playerClass, characterTest.getPlayerClass());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameRaceFromEnum() {
        Character characterTest = createTestCharacter();
        assertEquals(race, characterTest.getRace());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameGlobalLevel() {
        Character characterTest = createTestCharacter();
        assertEquals(globalLevel, characterTest.getGlobalLevel());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameExperience() {
        Character characterTest = createTestCharacter();
        assertEquals(experience, characterTest.getExperience());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameClassLevel() {
        Character characterTest = createTestCharacter();
        assertEquals(classLevel, characterTest.getClassLevel());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameClassExperience() {
        Character characterTest = createTestCharacter();
        assertEquals(classExperience, characterTest.getClassExperience());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameBackground() {
        Character characterTest = createTestCharacter();
        assertEquals(background, characterTest.getBackground());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"&#@","Efrim_Nal","Jack!"})
    public void testCreateNewCharacter_whenCharacterNameIsNullOrEmptyOrHasSpecialCharacter_returnThrowException(String name) {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            characterService.createNewCharacter(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
        });

        assertEquals("Character name can't be null or empty or contains invalid characters", exception.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterGlobalLevelOrClassLevelIsUnder1_returnThrowException() {
        //Arrange
        globalLevel = 0;
        classLevel = 0;

        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                characterService.createNewCharacter(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
        });

        assertEquals("Global level and Class level start at level 1", exception.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterGlobalExperienceIsUnder0_returnThrowException() {
        //Arrange
        experience = -1;
        classExperience = -1;

        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            characterService.createNewCharacter(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
        });

        assertEquals("Global experience and class experience points could not be negatives", exception.getMessage());
    }


}
