package com.Shambala.models.builder;

import com.Shambala.Enum.Race;

public interface CharacterExport {
    void nameIs(String name);

    void raceIs(Race race);

    void playerClassIs(String playerClass);

    void globalLevelIs(int globalLevel);

    void experienceIs(int experience);

    void classLevelIs(int classLevel);

    void classExperienceIs(int classExperience);

    void backgroundIs(String background);
}
