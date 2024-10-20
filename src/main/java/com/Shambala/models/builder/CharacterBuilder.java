package com.Shambala.models.builder;

import com.Shambala.Enum.Race;

public interface CharacterBuilder {
    String name();
    Race race();
    String playerClass();
    int globalLevel();
    int experience();
    int classLevel();
    int classExperience();
    String background();
}
