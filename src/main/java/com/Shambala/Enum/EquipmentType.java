package com.Shambala.Enum;

public enum EquipmentType {
    ARMOR("ARMOR"),
    WEAPON("WEAPON");

    private final String equipement;

    EquipmentType(String equipementType) {
        this.equipement = equipementType;
    }
}
