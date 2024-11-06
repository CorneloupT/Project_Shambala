package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import com.Shambala.models.export.CharacterExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CharacterTest {

    private Long id;
    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;
    private CharacterStats characterStats;
    private List<CharacterPrincipalStat> principalStatList;
    private CharacterInventory inventory;

    @BeforeEach
    void setUp() {
        id = 1L;
        name = "Efrim";
        race = Race.YSGANDIEN;
        playerClass = "Pyromancien";
        globalLevel = 5;
        experience = 1500;
        classLevel = 6;
        classExperience = 2000;
        background = "Bonjour";
        characterStats = new CharacterStats();
        principalStatList = new ArrayList<>();
        inventory = new CharacterInventory();

        CharacterPrincipalStatBuilder mockPrincipalStatBuilder = mock(CharacterPrincipalStatBuilder.class);
        when(mockPrincipalStatBuilder.getStatType()).thenReturn(StatType.PHYSICAL);
        when(mockPrincipalStatBuilder.getValue()).thenReturn(30);

        CharacterPrincipalStat principalStat = CharacterPrincipalStat.fromBuilder(mockPrincipalStatBuilder);
        principalStatList.add(principalStat);

    }

    private record InnerBuilder(long getId,
                                String getName,
                                Race getRace,
                                String getPlayerClass,
                                int getGlobalLevel,
                                int getExperience,
                                int getClassLevel,
                                int getClassExperience,
                                String getBackground,
                                CharacterStats getCharacterStats,
                                List<CharacterPrincipalStat> getPrincipalStatList,
                                CharacterInventory getInventory) implements CharacterBuilder {
    }

    private CharacterBuilder createTestCharacter() {
        return new InnerBuilder(id, name, race, playerClass, globalLevel, experience, classLevel, classExperience, background,
                characterStats, principalStatList, inventory);
    }

    @Test
    void should_create_character_from_builder() {
        Character character = Character.from(new InnerBuilder(1L,"coucou", Race.KHAZAD, "class", 100,
                150, 200, 250, "background", characterStats, principalStatList, inventory));
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

    @Test
    void testCreateNewCharacter_whenCharacterStatsAreProvided_returnCharacterStats() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(characterStats, characterTest.getCharacterStats());
    }

    @Test
    void testCreateNewCharacter_whenCharacterPrincipalStatsListIsProvided_returnPrincipalStatsList() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(principalStatList, characterTest.getPrincipalStatList());
    }

    @Test
    void testCreateNewCharacter_whenAddNewPrincipalStat_returnNewStatInList() {
        Character characterTest = Character.from(createTestCharacter());

        CharacterPrincipalStatBuilder principalStatBuilder = mock(CharacterPrincipalStatBuilder.class);
        when(principalStatBuilder.getStatType()).thenReturn(StatType.PSYCHIC);
        when(principalStatBuilder.getValue()).thenReturn(30);

        CharacterPrincipalStat principalStat = CharacterPrincipalStat.fromBuilder(principalStatBuilder);

        characterTest.addNewPrincipalStat(principalStat);
        assertTrue(characterTest.getPrincipalStatList().contains(principalStat));
    }

    @Test
    void testCreateNewCharacter_whenAddNewPrincipalStat_StatTypeShouldNotBeDuplicated() {
        Character characterTest = Character.from(createTestCharacter());

        CharacterPrincipalStatBuilder principalStatBuilder = mock(CharacterPrincipalStatBuilder.class);
        when(principalStatBuilder.getStatType()).thenReturn(StatType.PHYSICAL);
        when(principalStatBuilder.getValue()).thenReturn(30);

        CharacterPrincipalStat principalStat = CharacterPrincipalStat.fromBuilder(principalStatBuilder);

        DuplicateKeyException duplicateStatException = assertThrows(DuplicateKeyException.class,
                () -> characterTest.addNewPrincipalStat(principalStat));

        assertEquals("Character Principal Stat should not be duplicated", duplicateStatException.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterInventoryIsProvided_returnInventory() {
        Character characterTest = Character.from(createTestCharacter());
        assertEquals(inventory, characterTest.getInventory());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"&#@", "Efrim_Nal", "Jack!"})
    public void testCreateNewCharacter_whenCharacterNameIsNullOrEmptyOrHasSpecialCharacter_returnThrowException(String name) {
        this.name = name;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Character.from(createTestCharacter()));

        assertEquals("Character name can't be null, empty or containing invalid characters", exception.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterGlobalLevelOrClassLevelIsUnder1_returnThrowException() {
        //Arrange
        globalLevel = 0;
        classLevel = 0;

        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Character.from(createTestCharacter()));

        assertEquals("Global level and Class level start at level 1", exception.getMessage());
    }

    @Test
    void testCreateNewCharacter_whenCharacterGlobalExperienceIsUnder0_returnThrowException() {
        //Arrange
        experience = -1;
        classExperience = -1;

        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Character.from(createTestCharacter()));

        assertEquals("Global experience and class experience points could not be negatives", exception.getMessage());
    }


    @Test
    void shouldExportValues() {
        CharacterExport export = mock(CharacterExport.class);
        Character character = Character.from(createTestCharacter());
        character.exportTo(export);

        verify(export).setName(eq("Efrim"));
        verify(export).setRace(eq(Race.YSGANDIEN));
        verify(export).setPlayerClass(eq("Pyromancien"));
        verify(export).setGlobalLevel(eq(5));
        verify(export).setExperience(eq(1500));
        verify(export).setClassLevel(eq(6));
        verify(export).setClassExperience(eq(2000));
        verify(export).setBackground(eq("Bonjour"));
        verify(export).setCharacterStats(eq(characterStats));
        verify(export).setCharacterPrincipalStat(eq(principalStatList));
        verify(export).setCharacterInventory(eq(inventory));
    }


}