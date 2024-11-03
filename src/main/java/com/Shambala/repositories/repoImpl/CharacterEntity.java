package com.Shambala.repositories.repoImpl;

import com.Shambala.Enum.Race;
import com.Shambala.models.*;
import com.Shambala.models.Character;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.export.CharacterExport;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

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
    private CharacterStats characterStats;
    private List<CharacterPrincipalStat> principalStatList;
    private List<CharacterEquipment> equipmentList;
    private CharacterInventory inventory;

    Character toCharacterModel() {
        return Character.from(this);
    }

    @Override
    public void setCharacterPrincipalStat(List<CharacterPrincipalStat> principalStatList) {

    }

    @Override
    public void setCharacterEquipmentList(List<CharacterEquipment> equipmentList) {

    }

    @Override
    public void setCharacterInventory(CharacterInventory inventory) {

    }
}
