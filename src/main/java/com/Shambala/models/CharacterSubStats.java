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
        characterSubStats.verifyGreaterValueSubStat();
        characterSubStats.verifyLesserValueSubStat();
        characterSubStats.verifyDivisibleValueSubStat();
        return characterSubStats;
    }

    private void verifyDivisibleValueSubStat() {
        if (subStatValue % 5 != 0) {
            throw new IllegalArgumentException("Sub Stat should be divisible by 5");
        }
    }

    private void verifyLesserValueSubStat() {
        if (subStatValue < 5) {
            throw new IllegalArgumentException("Sub Stat should not be lesser than 5");
        }
    }

    private void verifyGreaterValueSubStat() {
        if (subStatValue > 30) {
            throw new IllegalArgumentException("Sub Stat should not be greater than 30");
        }
    }
}
