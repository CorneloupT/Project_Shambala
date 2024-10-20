package com.Shambala.models.builder;

import com.Shambala.Enum.Race;

public interface CharacterBuilder {
    String getName();
    Race getRace();
    String getPlayerClass();
    int getGlobalLevel();
    int getExperience();
    int getClassLevel();
    int getClassExperience();
    String getBackground();
}
