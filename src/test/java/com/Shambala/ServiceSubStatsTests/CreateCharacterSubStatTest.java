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
            CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName);

        //Assert
            assertNotNull(characterSubStats, "the createCharacterSubStat() should not return null");
    }

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnSameName() {
        CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
        String subStatName = "endurance";
        int subStatValue = 15;
        StatType statType = StatType.FGT;

        CharacterSubStats characterSubStats = characterSubStatService.createCharacterSubStat(subStatName);

        assertEquals(subStatName, characterSubStats.getSubStatName());

    }

}
