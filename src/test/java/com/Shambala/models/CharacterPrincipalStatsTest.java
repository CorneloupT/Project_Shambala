package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharacterPrincipalStatsTest {

    private StatType statType;
    private int value;
    private List<CharacterSubStats> subStatsList;
    private Character character;

    @BeforeEach
    void setUp() {
        statType = StatType.PSYCHIC;
        value = 45;

        subStatsList = new ArrayList<>();
        CharacterSubStatsBuilder mockSubStatBuilder = mock(CharacterSubStatsBuilder.class);
        when(mockSubStatBuilder.getStatType()).thenReturn(StatType.PSYCHIC);
        when(mockSubStatBuilder.getSubStatName()).thenReturn("Erudition");
        when(mockSubStatBuilder.getSubStatValue()).thenReturn(20);
        when(mockSubStatBuilder.getDescription()).thenReturn("Hello world");

        CharacterSubStats subStats1 = CharacterSubStats.fromSubStatBuilder(mockSubStatBuilder);
        subStatsList.add(subStats1);

        CharacterBuilder mockCharacterBuilder = mock(CharacterBuilder.class);
        when(mockCharacterBuilder.getId()).thenReturn(1L);
        when(mockCharacterBuilder.getName()).thenReturn("Character1");
        when(mockCharacterBuilder.getRace()).thenReturn(Race.YSGANDIEN);
        when(mockCharacterBuilder.getPlayerClass()).thenReturn("Mage");
        when(mockCharacterBuilder.getClassLevel()).thenReturn(1);
        when(mockCharacterBuilder.getClassExperience()).thenReturn(1);
        when(mockCharacterBuilder.getGlobalLevel()).thenReturn(1);
        when(mockCharacterBuilder.getExperience()).thenReturn(1);
        when(mockCharacterBuilder.getBackground()).thenReturn("hello");
        character = Character.from(mockCharacterBuilder);


    }

    private record TestBuilder(StatType getStatType, int getValue, List<CharacterSubStats> getSubStatsList, Character getCharacter) implements CharacterPrincipalStatBuilder {

    }

    private CharacterPrincipalStatBuilder createTestPrincipalStat() {
        return new TestBuilder(statType, value, subStatsList, character);
    }

    @Test
    void should_create_character_principal_stat_from_builder() {
        CharacterPrincipalStat characterPrincipalStat = CharacterPrincipalStat.fromBuilder(new TestBuilder(StatType.PSYCHIC, 50, subStatsList, character));
        assertNotNull(characterPrincipalStat);
    }

    @Test
    void testCreatePrincipalStats_whenStatTypeIsProvided_returnStatTypeValue() {
        CharacterPrincipalStat principalStatTest = CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        assertEquals(statType, principalStatTest.getStatType());
    }

    @Test
    void testCreatePrincipalStats_whenValueIsProvided_returnValue() {
        CharacterPrincipalStat principalStatTest = CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        assertEquals(value, principalStatTest.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 60, 47})
    void testCreatePrincipalStat_whenValueIsProvided_shouldBeGreaterThan10LesserThan50AndDivisibleBy5(int value) {
        this.value = value;
        IllegalArgumentException statValueException = assertThrows(IllegalArgumentException.class,
                () -> CharacterPrincipalStat.fromBuilder(createTestPrincipalStat()));

        assertEquals("Principal stat value should be greater than 10, lesser than 50 and divisible by 5", statValueException.getMessage());
    }

    @Test
    void testCreatePrincipalStat_whenPrincipalStatAreProvided_returnListOfSubStat() {
        CharacterPrincipalStat principalStatTest = CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        assertEquals(subStatsList, principalStatTest.getSubStatsList());
    }

    @Test
    void testCreatePrincipalStat_whenPrincipalStatTypeIsProvided_returnListOfSubStatWithTheSameType() {
        statType = StatType.DEXTERITY;
        IllegalArgumentException subStatTypeException = assertThrows(IllegalArgumentException.class,
                () -> CharacterPrincipalStat.fromBuilder(createTestPrincipalStat()));

        assertEquals("All sub Stat should be have same type than principal Stat", subStatTypeException.getMessage());
    }

    @Test
    void testCreatePrincipalStat_whenCharacterIdIsProvided_returnCharacterPrincipalStatWithCorrectCharacterId() {
        CharacterPrincipalStat principalStatTest = CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        assertNotNull(principalStatTest, "CharacterPrincipalStat should be created");
        assertEquals(character.getId(), principalStatTest.getCharacter().getId(),
                "L'ID du Character dans CharacterPrincipalStat devrait correspondre à celui du Character associé.");

    }

}
