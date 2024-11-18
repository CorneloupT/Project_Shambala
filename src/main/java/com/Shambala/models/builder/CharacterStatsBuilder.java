package com.Shambala.models.builder;

import com.Shambala.models.Character;

public interface CharacterStatsBuilder {
    long getId();
    int getLifePoints();
    int getLifePointsMax();
    int getENPoints();
    int getENPointsMax();
    int getLuckyPoints();
    int getProtection();
    Character getCharacter();
}
