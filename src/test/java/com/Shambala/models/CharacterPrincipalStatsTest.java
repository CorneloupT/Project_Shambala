package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharacterPrincipalStatsTest {

    private StatType statType;
    private int value;
    private List<CharacterSubStats> subStatsList;

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
    }

    private record TestBuilder(StatType getStatType, int getValue, List<CharacterSubStats> getSubStatsList) implements CharacterPrincipalStatBuilder {

    }

    private CharacterPrincipalStatBuilder createTestPrincipalStat() {
        return new TestBuilder(statType, value, subStatsList);
    }

    @Test
    void should_create_character_principal_stat_from_builder() {
        CharacterPrincipalStat characterPrincipalStat = CharacterPrincipalStat.fromBuilder(new TestBuilder(StatType.PSYCHIC, 50, subStatsList));
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
        IllegalArgumentException statValueException = assertThrows(IllegalArgumentException.class, () -> {
            CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        });

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
        IllegalArgumentException subStatTypeException = assertThrows(IllegalArgumentException.class, () -> {
           CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        });

        assertEquals("test", subStatTypeException.getMessage());
    }

}
