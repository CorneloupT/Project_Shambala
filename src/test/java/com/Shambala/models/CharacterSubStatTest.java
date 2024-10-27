package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void testCreateSubStat_whenSubStatIsGreaterThan30_returnError() {
        subStatValue = 35;
        IllegalArgumentException subStatGreaterException = assertThrows(IllegalArgumentException.class, () -> {
            CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        });

        assertEquals("Sub Stat should not be greater than 30", subStatGreaterException.getMessage());
    }

    @Test
    void testCreateSubStat_whenSubStatIsLesserThan5_returnError() {
        subStatValue = 0;
        IllegalArgumentException subStatLesserException = assertThrows(IllegalArgumentException.class, () -> {
           CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        });

        assertEquals("Sub Stat should not be lesser than 5", subStatLesserException.getMessage());
    }

    @Test
    void testCreateSubStat_whenSubStatIsNotDivisibleBy5_returnError() {
        subStatValue = 27;
        IllegalArgumentException subStatNotDivisibleBy5Exception = assertThrows(IllegalArgumentException.class, () -> {
            CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        });

        assertEquals("Sub Stat should be divisible by 5", subStatNotDivisibleBy5Exception.getMessage());
    }
}
