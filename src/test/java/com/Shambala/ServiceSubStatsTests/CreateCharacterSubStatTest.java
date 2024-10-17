package com.Shambala.ServiceSubStatsTests;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.Service.ServiceImpl.CharacterSubStatServiceImpl;
import com.Shambala.models.CharacterSubStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCharacterSubStatTest {

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnAllSubStats() {
        //Arrange
            CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
            String subStatName = "endurance";
            int subStatValue = 15;
            StatType statType = StatType.FGT;
        //Act
            CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName, subStatValue, statType);

        //Assert
            assertNotNull(characterSubStats, "the createCharacterSubStat() should not return null");
    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatName() {
        CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
        String subStatName = "endurance";
        int subStatValue = 15;
        StatType statType = StatType.FGT;

        CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName, subStatValue, statType);

        assertEquals(subStatName, characterSubStats.getSubStatName());

    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatValue() {
        CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
        String subStatName = "endurance";
        int subStatValue = 15;
        StatType statType = StatType.FGT;

        CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName, subStatValue, statType);

        assertEquals(subStatValue, characterSubStats.getSubStatValue());

    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameSubStatType() {
        CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
        String subStatName = "endurance";
        int subStatValue = 15;
        StatType statType = StatType.FGT;

        CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName, subStatValue, statType);

        assertEquals(statType, characterSubStats.getStatType());

    }
}
