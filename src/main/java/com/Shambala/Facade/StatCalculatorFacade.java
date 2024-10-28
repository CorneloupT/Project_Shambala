package com.Shambala.Facade;

import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;

import java.util.Random;

public class StatCalculatorFacade {

    private static Random random100 = new Random();

    public static int getValueOfDice100(int min, int max) {
        return min + random100.nextInt((max - min) + 1);
    }

    public static int addStatsValue(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        return principalStat.getValue() + subStats.getSubStatValue();
    }
}
