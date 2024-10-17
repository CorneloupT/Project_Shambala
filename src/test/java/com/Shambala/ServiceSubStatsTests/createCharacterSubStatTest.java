package com.Shambala.ServiceSubStatsTests;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.Service.ServiceImpl.CharacterSubStatServiceImpl;
import com.Shambala.models.CharacterSubStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class createCharacterSubStatTest {

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
}
