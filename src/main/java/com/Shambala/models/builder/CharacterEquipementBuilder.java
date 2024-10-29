package com.Shambala.models.builder;

import com.Shambala.Enum.MaterialType;

public interface CharacterEquipementBuilder {
    String getName();

    String getDescription();

    MaterialType getMaterialType();
}
