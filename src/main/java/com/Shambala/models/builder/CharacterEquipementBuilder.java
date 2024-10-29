package com.Shambala.models.builder;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;

public interface CharacterEquipementBuilder {
    String getName();

    String getDescription();

    MaterialType getMaterialType();

    Quality getQuality();

    int getBreakPoint();

    EquipmentType getEquipmentType();
}
