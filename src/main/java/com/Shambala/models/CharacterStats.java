package com.Shambala.models;

import com.Shambala.models.builder.CharacterStatsBuilder;
import com.Shambala.models.export.CharacterStatsExport;
import lombok.Getter;

@Getter
public class CharacterStats {

    private int lifePoints;
    private int lifePointsMax;
    private int ENPoints;
    private int ENPointsMax;
    private int luckyPoints;
    private int protection;

    public static CharacterStats fromStatBuilder(CharacterStatsBuilder characterStatsBuilder) {
        CharacterStats characterStats = new CharacterStats();
        characterStats.lifePoints = characterStatsBuilder.getLifePoint();
        characterStats.lifePointsMax = characterStatsBuilder.getLifePointMax();
        characterStats.ENPoints = characterStatsBuilder.getENPoints();
        characterStats.ENPointsMax = characterStatsBuilder.getENPointsMax();
        characterStats.luckyPoints = characterStatsBuilder.getLuckyPoint();
        characterStats.protection = characterStatsBuilder.getProtection();
        characterStats.verifyMaxLifePointsAndMaxENPoints();
        return characterStats;
    }

    public void verifyMaxLifePointsAndMaxENPoints() {
        if (lifePoints > lifePointsMax || ENPoints > ENPointsMax) {
            throw new IllegalArgumentException("life points and EN points are always less than or equal to their maximum");
        }
    }

    public void exportTo(CharacterStatsExport statsExport) {
        statsExport.setLifePoints();
        statsExport.setLifePointsMax();
        statsExport.setENPoints();
        statsExport.setENpointsMax();
        statsExport.setLuckyPoints();
        statsExport.setProtection();
    }

}
