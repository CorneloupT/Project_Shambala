package com.Shambala.Service;

import com.Shambala.models.CharacterStats;

public interface CharacterStatService {

    CharacterStats createNewStats(int lifePoints,
                                  int lifePointsMax,
                                  int ENPoints,
                                  int ENPointsMax,
                                  int luckyPoints,
                                  int protection,
                                  int physicalStat,
                                  int dexterityStat,
                                  int psychicStat,
                                  int willPowerStat,
                                  int fightStat);

    void verifyPrincipalCharacterStats(CharacterStats principalStats);
}
