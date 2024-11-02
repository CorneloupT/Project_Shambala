package com.Shambala.models;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
import lombok.Getter;

@Getter
public class CharacterEquipment {

    private String name;
    private String description;
    private MaterialType materialType;
    private Quality quality;
    private int breakPoint;
    private EquipmentType equipmentType;

    public static CharacterEquipment fromEquipmentBuilder(CharacterEquipmentBuilder equipmentBuilder) {
        CharacterEquipment characterEquipment = new CharacterEquipment();
        characterEquipment.name = equipmentBuilder.getName();
        characterEquipment.description = equipmentBuilder.getDescription();
        characterEquipment.materialType = equipmentBuilder.getMaterialType();
        characterEquipment.quality = equipmentBuilder.getQuality();
        characterEquipment.breakPoint = equipmentBuilder.getBreakPoint();
        characterEquipment.equipmentType = equipmentBuilder.getEquipmentType();
        characterEquipment.verifyWeaponPercentageBreakPointWhenQualityIsProvided();
        characterEquipment.verifyArmorPercentageBreakPointWhenQualityIsProvided();
        return characterEquipment;
    }

    private void verifyWeaponPercentageBreakPointWhenQualityIsProvided() {
        if (equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = switch (quality) {
                case NOVICE -> 60;
                case APPRENTICE -> 40;
                case CONFIRMED -> 25;
                case MASTER -> 10;
                case GRAND_MASTER -> 2;
            };
        }
    }

    private void verifyArmorPercentageBreakPointWhenQualityIsProvided() {
        if (equipmentType.equals(EquipmentType.ARMOR)) {
            breakPoint = switch (quality) {
                case NOVICE -> 75;
                case APPRENTICE -> 50;
                case CONFIRMED -> 35;
                case MASTER -> 15;
                case GRAND_MASTER -> 5;
            };
        }
    }

}
