package com.Shambala.Service.ServiceImpl;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.models.CharacterSubStats;

public class CharacterSubStatServiceImpl implements CharacterSubStatService {

    @Override
    public CharacterSubStats createCharacterSubStat(String subStatName, int subStatValue, StatType statType) {
        return new CharacterSubStats(subStatName, subStatValue, statType);
    }
}
