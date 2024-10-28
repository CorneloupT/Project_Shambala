package com.Shambala.Facade;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;


public class StatCalculatorFacade {
    ;
    public int getValueOfDice100() {
        return (int) (Math.random() * 100) + 1;
    }

    public int addStatsValue(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        return principalStat.getValue() + subStats.getSubStatValue();
    }

    public String resultD100AndConsequences(CharacterPrincipalStatBuilder principalStat, CharacterSubStatsBuilder subStats) {
        int addStatValue = addStatsValue(principalStat, subStats);
        int dice100Value = getValueOfDice100();

        return (dice100Value > addStatValue)
                ? (dice100Value >= 96 ? "Aie ! ça ressemble à un échec critique !" : "Fail! addStatValue is greater than the dice roll.")
                : (dice100Value <= 5 ? "Critical Success !!" : "Success! addStatValue is lesser than the dice roll.");
    }
}
