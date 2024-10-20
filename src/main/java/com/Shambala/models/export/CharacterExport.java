package com.Shambala.models.export;

import com.Shambala.Enum.Race;

public interface CharacterExport {

    void setName(String name);

    void setRace(Race race);

    void setPlayerClass(String playerClass);

    void setGlobalLevel(int globalLevel);

    void setExperience(int experience);

    void setClassLevel(int classLevel);

    void setClassExperience(int classExperience);

    void setBackground(String background);

}
