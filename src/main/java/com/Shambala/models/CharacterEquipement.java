package com.Shambala.models;

import com.Shambala.models.builder.CharacterEquipementBuilder;
import lombok.Getter;

@Getter
public class CharacterEquipement {

    private String name;

    public static CharacterEquipement fromEquipementBuilder(CharacterEquipementBuilder equipementBuilder) {
        CharacterEquipement characterEquipement = new CharacterEquipement();
        characterEquipement.name = equipementBuilder.getName();
        return characterEquipement;
    }

}
