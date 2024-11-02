package com.Shambala.Enum;

public enum EquipmentType {
    ARMOR("ARMOR"),
    WEAPON("WEAPON");

    private final String equipment;

    EquipmentType(String equipmentType) {
        this.equipment = equipmentType;
    }
}
