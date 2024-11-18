package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import com.Shambala.models.export.CharacterSubStatsExport;
import lombok.Getter;


@Getter
public class CharacterSubStats {

    private long id;
    private StatType statType;
    private String subStatName;
    private int subStatValue;
    private String description;

    public static CharacterSubStats fromSubStatBuilder(CharacterSubStatsBuilder builder) {
        CharacterSubStats characterSubStats = new CharacterSubStats();
        characterSubStats.id = builder.getId();
        characterSubStats.statType = builder.getStatType();
        characterSubStats.subStatName = builder.getSubStatName();
        characterSubStats.subStatValue = builder.getSubStatValue();
        characterSubStats.description = builder.getDescription();
        characterSubStats.verifyValueSubStat();
        return characterSubStats;
    }

    private void verifyValueSubStat() {
        if (subStatValue < 5 || subStatValue > 30 || subStatValue % 5 != 0) {
            throw new IllegalArgumentException("SubStat Value should not be greater than 30, lesser than 5 and should be divisible by 5");
        }
    }

    public void exportTo(CharacterSubStatsExport subStatsExport) {
        subStatsExport.setType(statType);
        subStatsExport.setSubStatName(subStatName);
        subStatsExport.setSubStatValue(subStatValue);
        subStatsExport.setDescription(description);
    }

}
