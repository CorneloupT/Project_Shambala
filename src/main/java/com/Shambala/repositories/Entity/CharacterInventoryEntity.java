package com.Shambala.repositories.Entity;

import com.Shambala.models.Character;
import com.Shambala.models.CharacterEquipment;
import com.Shambala.models.builder.CharacterInventoryBuilder;
import com.Shambala.models.export.CharacterInventoryExport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CharacterInventoryEntity implements CharacterInventoryExport, CharacterInventoryBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterEquipment> characterEquipment;

    private List<String> bag;
    private int goldAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

}
