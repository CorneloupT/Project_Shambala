package com.Shambala.Service.ServiceImpl;

import com.Shambala.Service.CharacterStatService;
import com.Shambala.models.CharacterStats;

public class CharacterStatServiceImpl implements CharacterStatService {

    @Override
    public CharacterStats createNewStats(int lifePoints,
                                         int lifePointsMax,
                                         int ENPoints,
                                         int ENPointsMax,
                                         int luckyPoints,
                                         int protection,
                                         int physicalStat,
                                         int dexterityStat,
                                         int psychicStat,
                                         int willPowerStat,
                                         int fightStat) {

        if (physicalStat >= 50 || physicalStat <= 10 || physicalStat % 5 != 0) {
            throw new IllegalArgumentException("Maximum of Physical Stat is 50, Minimum is 10 and should be divisible by 5");
        }
        if (dexterityStat >= 50 || dexterityStat <= 10 || dexterityStat % 5 != 0) {
            throw new IllegalArgumentException("Maximum of Dexterity Stat is 50, Minimum is 10 and should be divisible by 5");
        }
        if (psychicStat >= 50 || psychicStat <= 10 || psychicStat % 5 != 0) {
            throw new IllegalArgumentException("Maximum of Psychic Stat is 50, Minimum is 10 and should be divisible by 5");
        }
        if (willPowerStat >= 50 || willPowerStat <= 10 || willPowerStat % 5 != 0) {
            throw new IllegalArgumentException("Maximum of Will Power Stat is 50, Minimum is 10 and should be divisible by 5");
        }
        if (fightStat >= 50 || fightStat <= 10 || fightStat % 5 != 0) {
            throw new IllegalArgumentException("Maximum of Fight Stat is 50, Minimum is 10 and should be divisible by 5");
        }


        return new CharacterStats(
                lifePoints,
                lifePointsMax,
                ENPoints,
                ENPointsMax,
                luckyPoints,
                protection,
                physicalStat,
                dexterityStat,
                psychicStat,
                willPowerStat,
                fightStat);
    }
}
