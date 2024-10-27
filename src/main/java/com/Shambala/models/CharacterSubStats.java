package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSubStats {

    private StatType statType;
    private String subStatName;
    private int subStatValue;
    private String description;

    public static CharacterSubStats fromSubStatBuilder(CharacterSubStatsBuilder builder) {
        CharacterSubStats characterSubStats = new CharacterSubStats();
        characterSubStats.statType = builder.getStatType();
        characterSubStats.subStatName = builder.getSubStatName();
        characterSubStats.subStatValue = builder.getSubStatValue();
        characterSubStats.description = builder.getDescription();
        return characterSubStats;
    }
}
