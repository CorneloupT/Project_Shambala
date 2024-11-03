package com.Shambala.models.builder;

import com.Shambala.Enum.Race;
import com.Shambala.models.CharacterEquipment;
import com.Shambala.models.CharacterInventory;
import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterStats;

import java.util.List;

public interface CharacterBuilder {

    long getId();

    String getName();

    Race getRace();

    String getPlayerClass();

    int getGlobalLevel();

    int getExperience();

    int getClassLevel();

    int getClassExperience();

    String getBackground();

    CharacterStats getCharacterStats();

    List<CharacterPrincipalStat> getPrincipalStatList();

    List<CharacterEquipment> getEquipmentList();

    CharacterInventory getInventory();
}
