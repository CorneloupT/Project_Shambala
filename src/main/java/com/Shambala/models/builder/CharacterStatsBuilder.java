package com.Shambala.models.builder;

import com.Shambala.models.Character;

public interface CharacterStatsBuilder {
    long getId();
    int getLifePoint();
    int getLifePointMax();
    int getENPoints();
    int getENPointsMax();
    int getLuckyPoint();
    int getProtection();
    Character getCharacter();
}
