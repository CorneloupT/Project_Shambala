package com.Shambala.repositories.repoImpl;

import com.Shambala.Enum.Race;
import com.Shambala.models.Character;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.export.CharacterExport;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Une classe de type Entity devrait toujours rester au niveau de la couche de persistence et ne jamais aller plus haut
 */
@Data
class CharacterEntity implements CharacterExport, CharacterBuilder {

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

    Character toCharacterModel() {
        return Character.from(this);
    }

}
