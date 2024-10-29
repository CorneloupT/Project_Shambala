package com.Shambala.models;

import com.Shambala.Enum.MaterialType;
import com.Shambala.models.builder.CharacterEquipementBuilder;
import lombok.Getter;

@Getter
public class CharacterEquipment {

    private String name;
    private String description;
    private MaterialType materialType;

    public static CharacterEquipment fromEquipementBuilder(CharacterEquipementBuilder equipementBuilder) {
        CharacterEquipment characterEquipement = new CharacterEquipment();
        characterEquipement.name = equipementBuilder.getName();
        characterEquipement.description = equipementBuilder.getDescription();
        characterEquipement.materialType = equipementBuilder.getMaterialType();
        return characterEquipement;
    }

}
