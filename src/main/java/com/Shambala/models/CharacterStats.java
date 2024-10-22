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
        characterStats.verifyLifePointsAndMaxlifePoints();
        characterStats.verifyENPointsAndMaxENPoints();
        return characterStats;
    }

    public void verifyLifePointsAndMaxlifePoints() {
        if (lifePoints > lifePointsMax) {
            throw new IllegalArgumentException("life points are always inferior or egal to max life points");
        }
    }

    public void verifyENPointsAndMaxENPoints() {
        if (ENPoints > ENPointsMax) {
            throw new IllegalArgumentException("EN points are always inferior or egal to max EN points");
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
