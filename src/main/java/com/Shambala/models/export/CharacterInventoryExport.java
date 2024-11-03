package com.Shambala.models.export;

import com.Shambala.models.CharacterEquipment;

import java.util.List;

public interface CharacterInventoryExport {
    void setCharacterEquipment(List<CharacterEquipment> characterEquipment);

    void setBag(List<String> bag);

    void setGoldAmount(int goldAmount);
}
