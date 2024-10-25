package com.Shambala.Enum;

public enum StatType {
    PHY("Physical"),
    DEX("Dexterity"),
    PSY("Psychic"),
    WIL("WillPower"),
    FGT("Fight");

    private final String statType;

    StatType(String statType) {
        this.statType = statType;
    }

    public String getStatType() {
        return statType;
    }
}
