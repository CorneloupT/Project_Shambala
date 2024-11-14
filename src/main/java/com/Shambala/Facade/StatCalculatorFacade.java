package com.Shambala.Facade;

import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;

public class StatCalculatorFacade {

    public int getValueOfDice100() {
        return (int) (Math.random() * 100) + 1;
    }

    public int addStatsValue(CharacterPrincipalStat principalStat, CharacterSubStats subStats) {
        return principalStat.getValue() + subStats.getSubStatValue();
    }

    public String resultD100AndConsequences(CharacterPrincipalStat principalStat, CharacterSubStats subStats) {
        int addStatValue = addStatsValue(principalStat, subStats);
        int dice100Value = getValueOfDice100();

        return (dice100Value > addStatValue)
                ? (dice100Value >= 96 ? "Aie ! ça ressemble à un échec critique !" : "Fail! addStatValue is greater than the dice roll.")
                : (dice100Value <= 5 ? "Critical Success !!" : "Success! addStatValue is lesser than the dice roll.");
    }
}
