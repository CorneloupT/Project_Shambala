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
        characterEquipment.verifyQualityNoviceHasBreakPoint60WithTypeWeapon();
        characterEquipment.verifyQualityApprenticeHasBreakPoint40WithTypeWeapon();
        characterEquipment.verifyQualityConfirmedHasBreakPoint25WithTypeWeapon();
        characterEquipment.verifyQualityMasterHasBreakPoint10WithTypeWeapon();
        characterEquipment.verifyQualityGrandMasterHasBreakPoint2WithTypeWeapon();
        return characterEquipment;
    }

    private void verifyQualityNoviceHasBreakPoint60WithTypeWeapon() {
        if (quality.equals(Quality.NOVICE) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 60;
        }
    }

    private void verifyQualityApprenticeHasBreakPoint40WithTypeWeapon() {
        if (quality.equals(Quality.APPRENTICE) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 40;
        }
    }

    private void verifyQualityConfirmedHasBreakPoint25WithTypeWeapon() {
        if (quality.equals(Quality.CONFIRMED) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 25;
        }
    }

    private void verifyQualityMasterHasBreakPoint10WithTypeWeapon() {
        if (quality.equals(Quality.MASTER) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 10;
        }
    }

    private void verifyQualityGrandMasterHasBreakPoint2WithTypeWeapon() {
        if (quality.equals(Quality.GRAND_MASTER) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 2;
        }
    }

}
