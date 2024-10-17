package com.Shambala.Service;

import com.Shambala.Enum.Race;
import com.Shambala.models.Character;

public interface CharacterService {

    Character createNewCharacter(String name,
                                 Race race,
                                 String playerClass,
                                 int globalLevel,
                                 int experience,
                                 int classLevel,
                                 int classExperience,
                                 String background);


}
