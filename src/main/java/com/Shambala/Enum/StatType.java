package com.Shambala.Enum;

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

    public String getStatType() {
        return statType;
    }
}
