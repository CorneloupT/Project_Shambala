package com.Shambala.Service.ServiceImpl;

import com.Shambala.Enum.Race;
import com.Shambala.Service.CharacterService;
import com.Shambala.models.Character;

public class CharacterServiceImpl implements CharacterService {

    @Override
    public Character createNewCharacter(String name,
                                        Race race,
                                        String playerClass,
                                        int globalLevel,
                                        int experience,
                                        int classLevel,
                                        int classExperience,
                                        String background) {

        if (name == null || name.isEmpty() || !name.matches("^[a-zA-Z0-9 ]+$")) {
            throw new IllegalArgumentException("Character name can't be null or empty or contains invalid characters");
        }
        if (globalLevel < 1 || classLevel < 1) {
            throw new IllegalArgumentException("Global level and Class level start at level 1");
        }
        if (experience < 0 || classExperience < 0) {
            throw new IllegalArgumentException("Global experience and class experience points could not be negatives");
        }

        return new Character(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background);
    }

}
