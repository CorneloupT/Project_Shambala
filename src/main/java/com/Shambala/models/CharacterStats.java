package com.Shambala.models;

import com.Shambala.models.builder.CharacterStatsBuilder;
import com.Shambala.models.export.CharacterStatsExport;
import lombok.Getter;

@Getter
public class CharacterStats {

    private long id;
    private int lifePoints;
    private int lifePointsMax;
    private int ENPoints;
    private int ENPointsMax;
    private int luckyPoints;
    private int protection;
    private Character character;

    public static CharacterStats fromStatBuilder(CharacterStatsBuilder characterStatsBuilder) {
        CharacterStats characterStats = new CharacterStats();
        characterStats.id = characterStatsBuilder.getId();
        characterStats.lifePoints = characterStatsBuilder.getLifePoints();
        characterStats.lifePointsMax = characterStatsBuilder.getLifePointsMax();
        characterStats.ENPoints = characterStatsBuilder.getENPoints();
        characterStats.ENPointsMax = characterStatsBuilder.getENPointsMax();
        characterStats.luckyPoints = characterStatsBuilder.getLuckyPoints();
        characterStats.protection = characterStatsBuilder.getProtection();
        characterStats.character = characterStatsBuilder.getCharacter();
        characterStats.verifyMaxLifePointsAndMaxENPoints();
        return characterStats;
    }

    public void verifyMaxLifePointsAndMaxENPoints() {
        if (lifePoints > lifePointsMax || ENPoints > ENPointsMax) {
            throw new IllegalArgumentException("life points and EN points are always less than or equal to their maximum");
        }
    }

    public void exportTo(CharacterStatsExport statsExport) {
        statsExport.setLifePoints(lifePoints);
        statsExport.setLifePointsMax(lifePointsMax);
        statsExport.setENPoints(ENPoints);
        statsExport.setENPointsMax(ENPointsMax);
        statsExport.setLuckyPoints(luckyPoints);
        statsExport.setProtection(protection);
        statsExport.setCharacter(character);
    }

}
