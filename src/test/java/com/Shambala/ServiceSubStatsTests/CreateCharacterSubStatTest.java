package com.Shambala.ServiceSubStatsTests;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.Service.ServiceImpl.CharacterSubStatServiceImpl;
import com.Shambala.models.CharacterSubStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCharacterSubStatTest {

    private CharacterSubStatService characterSubStatService;

    private String subStatName;
    private int subStatValue;
    private String description;
    private StatType statType;

    @BeforeEach
    void setUp() {
        characterSubStatService = new CharacterSubStatServiceImpl();
        subStatName = "endurance";
        subStatValue = 15;
        description = "explain sub stat";
        statType = StatType.FGT;
    }

    private CharacterSubStats createSubStats() {
        return characterSubStatService.createCharacterSubStat(subStatName, subStatValue, description, statType);
    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnAllSubStats() {
        //Arrange
           // CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
           // String subStatName = "endurance";
           // int subStatValue = 15;
           // StatType statType = StatType.FGT;
        //Act
            CharacterSubStats characterSubStatsTest = createSubStats();

        //Assert
            assertNotNull(characterSubStatsTest, "the createCharacterSubStat() should not return null");
    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatName() {
        CharacterSubStats characterSubStatsTest = createSubStats();
        assertEquals(subStatName, characterSubStatsTest.getSubStatName());

    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatValue() {
        CharacterSubStats characterSubStatsTest = createSubStats();
        assertEquals(subStatValue, characterSubStatsTest.getSubStatValue());

    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameDescription() {
        CharacterSubStats characterSubStatsTest = createSubStats();
        assertEquals(description, characterSubStatsTest.getDescription());

    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatType() {
        CharacterSubStats characterSubStatsTest = createSubStats();
        assertEquals(statType, characterSubStatsTest.getStatType());
    }
}
