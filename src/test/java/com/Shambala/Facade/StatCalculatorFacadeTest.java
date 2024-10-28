package com.Shambala.Facade;

import static org.junit.jupiter.api.Assertions.*;

import com.Shambala.Enum.StatType;
import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StatCalculatorFacadeTest {

    @Test
    void testGetRandomValueOfDice100() {
        int randomValue = StatCalculatorFacade.getValueOfDice100(1, 100);
        assertTrue(randomValue >= 1 && randomValue <= 100, "la valeur du D100 est entre 1 et 100");
    }

    @Test
    void testAddPrincipalAndSubStatValue() {
        int result = StatCalculatorFacade.getValueOfDice100(principalStat, subStat);
    }
}
