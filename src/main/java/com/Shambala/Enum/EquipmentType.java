package com.Shambala.Enum;

public enum EquipmentType {
    ARMOR("ARMOR"),
    ONEHAND_WEAPON("ONEHAND_WEAPON"),
    TWOHAND_WEAPON("TWOHAND_WEAPON");

    private final String equipment;

    EquipmentType(String equipmentType) {
        this.equipment = equipmentType;
    }
}
