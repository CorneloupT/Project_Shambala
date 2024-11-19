package com.Shambala.models.export;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.CharacterInventory;

public interface CharacterEquipmentExport {
    void setName(String name);

    void setDescription(String description);

    void setMaterialType(MaterialType materialType);

    void setQuality(Quality quality);

    void setBreakPoint(int breakPoint);

    void setEquipmentType(EquipmentType equipmentType);

    void setCharacterInventory(CharacterInventory inventory);
}
