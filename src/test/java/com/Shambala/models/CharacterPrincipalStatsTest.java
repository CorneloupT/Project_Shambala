package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPrincipalStatsTest {

    private StatType statType;
    private int value;

    @BeforeEach
    void setUp() {
        statType = StatType.PHYSICAL;
    }

    private record TestBuilder(StatType getStatType, int getValue) implements CharacterPrincipalStatBuilder {

    }

    private CharacterPrincipalStatBuilder createTestPrincipalStat() {
        return new TestBuilder(statType, value);
    }

    @Test
    void should_create_character_principal_stat_from_builder() {
        CharacterPrincipalStat characterPrincipalStat = CharacterPrincipalStat.fromBuilder(new TestBuilder(StatType.PHYSICAL, 50));
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

}
