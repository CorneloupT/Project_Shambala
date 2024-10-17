package com.Shambala.Service.ServiceImpl;

import com.Shambala.Enum.StatType;
import com.Shambala.Service.CharacterSubStatService;
import com.Shambala.models.CharacterSubStats;

public class CharacterSubStatServiceImpl implements CharacterSubStatService {

    @Override
    public CharacterSubStats createCharacterSubStat(String subStatName) {
        return new CharacterSubStats(subStatName);
    }
}
