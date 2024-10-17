package com.Shambala.ServiceSubStatsTests;

import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.Service.ServiceImpl.CharacterSubStatServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class createCharacterSubStatTest {

    @Test
    void testCreateCharacterSubStat_whenSubStatsAreProvided_returnAllSubStats() {
        //Arrange
            CharacterSubStatService characterSubStatService = new CharacterSubStatServiceImpl();
            String subStatName = "endurance";
            int subStatValue = 15;
        //Act
            characterSubStatService.createCharacterSubStat();

        //Assert

    }
}
