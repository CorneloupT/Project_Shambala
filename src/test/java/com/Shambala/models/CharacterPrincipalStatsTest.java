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

    @Test
    void testCreatePrincipalStat_whenValueIsProvided_shouldBeGreaterThan10() {
        value = 5;
        IllegalArgumentException statValueGreaterException = assertThrows(IllegalArgumentException.class, () -> {
            CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        });

        assertEquals("Principal stat value should be greater than 10", statValueGreaterException.getMessage());
    }

    @Test
    void testCreatePrincipalStat_whenValueIsProvided_shouldBeLesserThan50() {
        value = 60;
        IllegalArgumentException statValueLesserException = assertThrows(IllegalArgumentException.class, () -> {
            CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        });

        assertEquals("Principal stat value should be lesser than 50", statValueLesserException.getMessage());
    }

    @Test
    void testCreatePrincipalStat_whenValueIsProvided_shouldBeDivisibleBy5() {
        value = 47;
        IllegalArgumentException statValueIncorrectException = assertThrows(IllegalArgumentException.class, () -> {
            CharacterPrincipalStat.fromBuilder(createTestPrincipalStat());
        });

        assertEquals("Principal stat value should be divisible by 5", statValueIncorrectException.getMessage());
    }
}
