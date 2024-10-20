package com.Shambala.models;

import com.Shambala.models.builder.CharacterStatsBuilder;
import com.Shambala.models.export.CharacterStatsExport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
        return characterStats;
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
