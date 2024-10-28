package com.Shambala.Facade;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;


public class StatCalculatorFacade {

    public int getValueOfDice100() {
        return (int) (Math.random() * 100) + 1;
    }

    public int addStatsValue(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        return principalStat.getValue() + subStats.getSubStatValue();
    }

    public String resultD100AndConsequences(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        int addStatValue = addStatsValue(principalStat, subStats);
        int dice100Value = getValueOfDice100();

        if (dice100Value > addStatValue) {
            return "Fail! addStatValue is greater than the dice roll.";
        } else {
            return "Succes! addStatValue is lesser than the dice roll.";
        }
    }
}
