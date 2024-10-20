package com.Shambala.repositories.repoImpl;

import com.Shambala.Enum.Race;
import com.Shambala.models.Character;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.builder.CharacterExport;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Une classe de type Entity devrait toujours rester au niveau de la couche de persistence et ne jamais aller plus haut
 */
@Data
class CharacterEntity implements CharacterExport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;

    public Character toModel() {
        return Character.from(new InnerCharacterBuilder(name, race, playerClass, globalLevel, experience, classLevel, classExperience, background));
    }

    @Override
    public void nameIs(String name) {
        this.name = name;
    }

    @Override
    public void raceIs(Race race) {
        this.race = race;
    }

    @Override
    public void playerClassIs(String playerClass) {
        this.playerClass = playerClass;
    }

    @Override
    public void globalLevelIs(int globalLevel) {
        this.globalLevel = globalLevel;
    }

    @Override
    public void experienceIs(int experience) {
        this.experience = experience;
    }

    @Override
    public void classLevelIs(int classLevel) {
        this.classLevel = classLevel;
    }

    @Override
    public void classExperienceIs(int classExperience) {
        this.classExperience = classExperience;
    }

    @Override
    public void backgroundIs(String background) {
        this.background = background;
    }

    private record InnerCharacterBuilder(String name,
                                         Race race,
                                         String playerClass,
                                         int globalLevel,
                                         int experience,
                                         int classLevel,
                                         int classExperience,
                                         String background)
            implements CharacterBuilder {
    }
}
