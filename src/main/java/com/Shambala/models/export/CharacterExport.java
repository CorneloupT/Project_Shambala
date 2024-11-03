package com.Shambala.models.export;

import com.Shambala.Enum.Race;
import com.Shambala.models.CharacterEquipment;
import com.Shambala.models.CharacterInventory;
import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterStats;

import java.util.List;

public interface CharacterExport {

    void setName(String name);

    void setRace(Race race);

    void setPlayerClass(String playerClass);

    void setGlobalLevel(int globalLevel);

    void setExperience(int experience);

    void setClassLevel(int classLevel);

    void setClassExperience(int classExperience);

    void setBackground(String background);

    void setId(long id);

    void setCharacterStats(CharacterStats characterStats);

    void setCharacterPrincipalStat(List<CharacterPrincipalStat> principalStatList);

    void setCharacterEquipmentList(List<CharacterEquipment> equipmentList);

    void setCharacterInventory(CharacterInventory inventory);
}
