package com.Shambala.models.builder;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.CharacterInventory;

public interface CharacterEquipmentBuilder {
    String getName();

    String getDescription();

    MaterialType getMaterialType();

    Quality getQuality();

    int getBreakPoint();

    EquipmentType getEquipmentType();

    long getId();

    CharacterInventory getCharacterInventory();
}
