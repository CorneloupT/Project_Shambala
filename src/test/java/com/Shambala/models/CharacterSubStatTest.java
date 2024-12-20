package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import com.Shambala.models.export.CharacterSubStatsExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharacterSubStatTest {

    private long id;
    private StatType statType;
    private String subStatName;
    private int subStatValue;
    private String description;
    private CharacterPrincipalStat principalStat;

    @BeforeEach
    void setUp() {
        id = 1L;
        statType = StatType.PHYSICAL;
        subStatName = "Endurance";
        subStatValue = 15;
        description = "hello world";
        principalStat = new CharacterPrincipalStat();
    }

    private record testBuilder(long getId, StatType getStatType, String getSubStatName, int getSubStatValue, String getDescription, CharacterPrincipalStat getPrincipalStat) implements CharacterSubStatsBuilder {

    }

    private CharacterSubStatsBuilder createTestSubStat() {
        return new testBuilder(id, statType, subStatName, subStatValue, description, principalStat);
    }


    @Test
    void should_create_character_sub_stat_from_builder() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(new testBuilder(id, statType, subStatName, subStatValue, description, principalStat));
        assertNotNull(characterSubStats);
    }

    @Test
    void testCreateSubStat_whenIdIsProvided_returnId() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(id, characterSubStats.getId());
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
    void testCreateSubStat_whenPrincipalStatIsProvided_returnPrincipalStat() {
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        assertEquals(principalStat, characterSubStats.getPrincipalStat());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 14, 31})
    void testCreateSubStat_whenSubStatIsGreaterThan50_OrLesserThan10_OrNotDivisibleBy5_returnError(int subStatValue) {
        this.subStatValue = subStatValue;
        IllegalArgumentException subStatValueException = assertThrows(IllegalArgumentException.class,
                () -> CharacterSubStats.fromSubStatBuilder(createTestSubStat()));

        assertEquals("SubStat Value should not be greater than 30, lesser than 5 and should be divisible by 5", subStatValueException.getMessage());
    }

    @Test
    void shouldExportValues() {
        CharacterSubStatsExport subStatsExport = mock(CharacterSubStatsExport.class);
        CharacterSubStats characterSubStats = CharacterSubStats.fromSubStatBuilder(createTestSubStat());
        characterSubStats.exportTo(subStatsExport);

        verify(subStatsExport).setType(statType);
        verify(subStatsExport).setSubStatName(subStatName);
        verify(subStatsExport).setSubStatValue(subStatValue);
        verify(subStatsExport).setDescription(description);
        verify(subStatsExport).setPrincipalStat(principalStat);
    }
}
