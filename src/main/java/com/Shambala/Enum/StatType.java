package com.Shambala.Enum;

import com.Shambala.models.builder.CharacterSubStatsBuilder;
import lombok.Getter;

@Getter
public enum StatType {
    PHYSICAL("Physical"),
    DEXTERITY("Dexterity"),
    PSYCHIC("Psychic"),
    WILLPOWER("WillPower"),
    FIGHT("Fight");

    private final String statType;

    StatType(String statType) {
        this.statType = statType;
    }

}
