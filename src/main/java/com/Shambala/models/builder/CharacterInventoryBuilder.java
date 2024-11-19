package com.Shambala.models.builder;

import com.Shambala.models.Character;
import com.Shambala.models.CharacterEquipment;

import java.util.List;

public interface CharacterInventoryBuilder {
    List<CharacterEquipment> getCharacterEquipment();

    List<String> getBag();

    int getGoldAmount();

    long getId();

    Character getCharacter();
}
