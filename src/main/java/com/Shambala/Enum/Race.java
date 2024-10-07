package com.Shambala.Enum;

public enum Race {
    YSGANDIEN("YSGANDIEN"),
    YSGANDIENNE("YSGANDIENNE"),
    KHAZAD("KHAZAD");

    private final String race;

    Race(String raceName) {
        this.race = raceName;
    }

    public String getRaceName() {
        return race;
    }
}
