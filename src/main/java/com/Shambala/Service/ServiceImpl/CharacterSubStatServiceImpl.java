package com.Shambala.Service.ServiceImpl;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.models.CharacterSubStats;

public class CharacterSubStatServiceImpl implements CharacterSubStatService {

    @Override
    public CharacterSubStats createCharacterSubStat(String subStatName, int subStatValue, String description, StatType statType) {
        return new CharacterSubStats(subStatName, subStatValue, description, statType);
    }
}
