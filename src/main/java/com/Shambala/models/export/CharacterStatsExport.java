package com.Shambala.models.export;

import com.Shambala.models.Character;

public interface CharacterStatsExport {

    void setLifePoints(int lifePoints);

    void setLifePointsMax(int lifePointsMax);

    void setENPoints(int ENPoints);

    void setENPointsMax(int ENPointsMax);

    void setLuckyPoints(int luckyPoints);

    void setProtection(int protection);

    void setCharacter(Character character);
}
