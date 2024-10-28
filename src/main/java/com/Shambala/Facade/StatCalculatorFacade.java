package com.Shambala.Facade;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;

import java.util.Random;

public class StatCalculatorFacade {

    private static Random random100 = new Random();

    public static int getValueOfDice100() {
        return random100.nextInt(100+ 1);
    }

    public static int addStatsValue(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        return principalStat.getValue() + subStats.getSubStatValue();
    }

    public String resultD100IsFail(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        int addStatValue = addStatsValue(principalStat, subStats);
        int dice100Value = getValueOfDice100();
        if (addStatValue > dice100Value) {
            return "Fail! addStatValue is greater than the dice roll.";
        } else {
            return "Success! addStatValue is lesser than the dice roll.";
        }
    }
}
