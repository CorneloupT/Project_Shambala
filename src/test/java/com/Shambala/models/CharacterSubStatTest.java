package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterSubStatTest {

    private StatType statType;
    private String subStatName;
    private int subStatValue;
    private String description;

    @BeforeEach
    void setUp() {
        statType = StatType.PHYSICAL;
        subStatName = "Endurance";
        subStatValue = 15;
        description = "hello world";
    }

    private record testBuilder(StatType getStatType, String getSubStatName, int getSubStatValue, String getDescription) implements CharacterSubStatsBuilder {

    }

    private CharacterSubStatsBuilder createTestSubStat() {
        return new testBuilder(statType, subStatName, subStatValue,description);
    }

    @Test
    void should_create_character_sub_stat_from_builder() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(new testBuilder(statType, subStatName, subStatValue, description));
        assertNotNull(characterSubStats);
    }

    @Test
    void testCreateSubStat_whenStatTypeIsProvided_returnStatType() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(statType, characterSubStats.getStatType());
    }

    @Test
    void testCreateSubStat_whenSubStatNameIsProvided_returnName() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(subStatName, characterSubStats.getSubStatName());
    }

    @Test
    void testCreateSubStat_whenSubStatValueIsProvided_returnSubStatValue() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(subStatValue, characterSubStats.getSubStatValue());
    }

    @Test
    void testCreateSubStat_whenDescriptionIsProvided_returnDescription() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(description, characterSubStats.getDescription());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 14, 31})
    void testCreateSubStat_whenSubStatIsGreaterThan50_OrLesserThan10_OrNotDivisibleBy5_returnError(int subStatValue) {
        this.subStatValue = subStatValue;
        IllegalArgumentException subStatValueException = assertThrows(IllegalArgumentException.class, () -> {
           CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        });

        assertEquals("SubStat Value should not be greater than 30, lesser than 5 and should be divisibleby 5", subStatValueException.getMessage());
    }
}
