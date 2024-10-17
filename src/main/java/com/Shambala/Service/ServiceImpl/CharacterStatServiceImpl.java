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

    @Override
    public void verifyPrincipalCharacterStats(CharacterStats principalStats) {
        int[] principalStatsToCheck = {
                principalStats.getPhysicalStat(),
                principalStats.getDexterityStat(),
                principalStats.getPsychicStat(),
                principalStats.getWillPowerStat(),
                principalStats.getFightStat()
        };

        for(int principalStat : principalStatsToCheck) {
            if (principalStat >= 50 || principalStat <= 10 || principalStat % 5 != 0 ) {
                throw new IllegalArgumentException("Principal Stat should not be superior to 50, inferior to 10 and divisible by 5");
            }
        }

    }

}

