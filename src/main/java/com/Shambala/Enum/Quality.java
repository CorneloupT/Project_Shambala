package com.Shambala.Enum;

public enum Quality {
    NOVICE("NOVICE"),
    APPRENTICE("APPRENTICE"),
    CONFIRMED("CONFIRMED"),
    MASTER("MASTER"),
    GRAND_MASTER("GRAND_MASTER");

    private final String quality;

    Quality(String quality) {
        this.quality = quality;
    }
}
