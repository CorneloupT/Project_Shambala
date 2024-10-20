package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.CharacterExport;
import lombok.Getter;

@Getter
public class Character {

    // TODO  L'id a disparu, à voir si c'est voulu ou pas ! Il faudra surement le remettre

    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;

    public static Character from(CharacterBuilder builder) {
        Character character = new Character();
        character.name = builder.name();
        character.race = builder.race();
        character.playerClass = builder.playerClass();
        character.globalLevel = builder.globalLevel();
        character.experience = builder.experience();
        character.classLevel = builder.classLevel();
        character.classExperience = builder.classExperience();
        character.background = builder.background();
        character.verify();
        return character;
    }

    private void verify() {
        if (name == null || name.isEmpty() || !name.matches("^[a-zA-Z0-9 ]+$")) {
            throw new IllegalArgumentException("Character name can't be null, empty or containing invalid characters");
        }
        if (globalLevel < 1 || classLevel < 1) {
            throw new IllegalArgumentException("Global level and Class level start at level 1");
        }
        if (experience < 0 || classExperience < 0) {
            throw new IllegalArgumentException("Global experience and class experience points could not be negatives");
        }
    }

    public void exportTo(CharacterExport export) {
        export.nameIs(name);
        export.raceIs(race);
        export.playerClassIs(playerClass);
        export.globalLevelIs(globalLevel);
        export.experienceIs(experience);
        export.classLevelIs(classLevel);
        export.classExperienceIs(classExperience);
        export.backgroundIs(background);
    }
}