package com.Shambala.models;

import com.Shambala.Enum.Race;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.export.CharacterExport;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {

    private long id;
    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;
    private CharacterStats characterStats;
    private List<CharacterPrincipalStat> principalStatList;
    private List<CharacterEquipment> equipmentList;
    private CharacterInventory inventory;

    public static Character from(CharacterBuilder builder) {
        Character character = new Character();
        character.id = builder.getId();
        character.name = builder.getName();
        character.race = builder.getRace();
        character.playerClass = builder.getPlayerClass();
        character.globalLevel = builder.getGlobalLevel();
        character.experience = builder.getExperience();
        character.classLevel = builder.getClassLevel();
        character.classExperience = builder.getClassExperience();
        character.background = builder.getBackground();
        character.characterStats = builder.getCharacterStats();
        character.principalStatList = builder.getPrincipalStatList();
        character.equipmentList = builder.getEquipmentList();
        character.inventory = builder.getInventory();
        character.verifyCharacterNameAndValueOfLevelAndExperience();
        return character;
    }

    private void verifyCharacterNameAndValueOfLevelAndExperience() {
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
        export.setId(id);
        export.setName(name);
        export.setRace(race);
        export.setPlayerClass(playerClass);
        export.setGlobalLevel(globalLevel);
        export.setExperience(experience);
        export.setClassLevel(classLevel);
        export.setClassExperience(classExperience);
        export.setBackground(background);
        export.setCharacterStats(characterStats);
        export.setCharacterPrincipalStat(principalStatList);
        export.setCharacterEquipmentList(equipmentList);
        export.setCharacterInventory(inventory);
    }
}