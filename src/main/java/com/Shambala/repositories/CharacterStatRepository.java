package com.Shambala.repositories;

import com.Shambala.models.CharacterStats;

public interface CharacterStatRepository {
    void saveNewStat(CharacterStats characterStats);
}
