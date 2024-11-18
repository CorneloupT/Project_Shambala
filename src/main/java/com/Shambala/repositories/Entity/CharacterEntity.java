package com.Shambala.repositories.Entity;

import com.Shambala.Enum.Race;
import com.Shambala.models.*;
import com.Shambala.models.Character;
import com.Shambala.models.builder.CharacterBuilder;
import com.Shambala.models.export.CharacterExport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Une classe de type Entity devrait toujours rester au niveau de la couche de persistence et ne jamais aller plus haut
 */
@Data
public class CharacterEntity implements CharacterExport, CharacterBuilder {

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characterStats_id", referencedColumnName = "id")
    private CharacterStats characterStats;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterPrincipalStat> principalStatList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private CharacterInventory inventory;

    public Character toCharacterModel() {
        return Character.from(this);
    }


    @Override
    public void setCharacterPrincipalStat(List<CharacterPrincipalStat> principalStatList) {

    }

    @Override
    public void setCharacterInventory(CharacterInventory inventory) {

    }

    @Override
    public void setUser(User user) {

    }

}
