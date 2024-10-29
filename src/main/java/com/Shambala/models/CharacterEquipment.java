package com.Shambala.models;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipementBuilder;
import lombok.Getter;

@Getter
public class CharacterEquipment {

    private String name;
    private String description;
    private MaterialType materialType;
    private Quality quality;
    private int breakPoint;
    private EquipmentType equipmentType;

    public static CharacterEquipment fromEquipementBuilder(CharacterEquipementBuilder equipementBuilder) {
        CharacterEquipment characterEquipement = new CharacterEquipment();
        characterEquipement.name = equipementBuilder.getName();
        characterEquipement.description = equipementBuilder.getDescription();
        characterEquipement.materialType = equipementBuilder.getMaterialType();
        characterEquipement.quality = equipementBuilder.getQuality();
        characterEquipement.breakPoint = equipementBuilder.getBreakPoint();
        characterEquipement.equipmentType = equipementBuilder.getEquipmentType();
        characterEquipement.verifyQualityNoviceHasBreakPoint60WithTypeWeapon();
        return characterEquipement;
    }

    private void verifyQualityNoviceHasBreakPoint60WithTypeWeapon() {
        if (quality.equals(Quality.NOVICE) && equipmentType.equals(EquipmentType.WEAPON)) {
            breakPoint = 60;
        }
    }


}
