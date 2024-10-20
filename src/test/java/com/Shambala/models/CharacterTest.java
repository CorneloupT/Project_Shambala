package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.CharacterExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharacterTest {

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
        name = "Efrim";
        race = Race.YSGANDIEN;
        playerClass = "Pyromancien";
        globalLevel = 5;
        experience = 1500;
        classLevel = 6;
        classExperience = 2000;
        background = "Bonjour";
    }

    private CharacterBuilder createTestCharacter() {
        return new InnerBuilder(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
    }

    @Test
    void should_create_character_from_builder() {
        Character character = Character.from(new InnerBuilder("coucou", Race.KHAZAD, "class", 100,
                150, 200, 250, "background"));
        assertNotNull(character);
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameName() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(name, characterTest.getName());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSamePlayerClass() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(playerClass, characterTest.getPlayerClass());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameRaceFromEnum() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(race, characterTest.getRace());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameGlobalLevel() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(globalLevel, characterTest.getGlobalLevel());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameExperience() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(experience, characterTest.getExperience());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameClassLevel() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(classLevel, characterTest.getClassLevel());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameClassExperience() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(classExperience, characterTest.getClassExperience());
    }

    @Test
    void testCreateNewCharacter_whenCharacterDetailsProvided_returnSameBackground() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(background, characterTest.getBackground());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"&#@", "Efrim_Nal", "Jack!"})
    public void testCreateNewCharacter_whenCharacterNameIsNullOrEmptyOrHasSpecialCharacter_returnThrowException(String name) {
        this.name = name;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Character.from(createTestCharacter());
        });

        assertEquals("Character name can't be null, empty or containing invalid characters", exception.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterGlobalLevelOrClassLevelIsUnder1_returnThrowException() {
        //Arrange
        globalLevel = 0;
        classLevel = 0;

        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Character.from(createTestCharacter());
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
            Character.from(createTestCharacter());
        });

        assertEquals("Global experience and class experience points could not be negatives", exception.getMessage());
    }

    @Test
    void shouldExportValues() {
        CharacterExport export = mock(CharacterExport.class);
        Character character = Character.from(createTestCharacter());
        character.exportTo(export);

        verify(export).nameIs(eq("Efrim"));
        verify(export).raceIs(eq(Race.YSGANDIEN));
        verify(export).playerClassIs(eq("Pyromancien"));
        verify(export).globalLevelIs(eq(5));
        verify(export).experienceIs(eq(1500));
        verify(export).classLevelIs(eq(6));
        verify(export).classExperienceIs(eq(2000));
        verify(export).backgroundIs(eq("Bonjour"));
    }

    private record InnerBuilder(String name,
                                Race race,
                                String playerClass,
                                int globalLevel,
                                int experience,
                                int classLevel,
                                int classExperience,
                                String background) implements CharacterBuilder {
    }

}