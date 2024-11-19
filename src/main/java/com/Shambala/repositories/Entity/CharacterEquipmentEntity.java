package com.Shambala.repositories.Entity;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.CharacterInventory;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
import com.Shambala.models.export.CharacterEquipmentExport;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CharacterEquipmentEntity implements CharacterEquipmentExport, CharacterEquipmentBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private MaterialType materialType;
    private Quality quality;
    private int breakPoint;
    private EquipmentType equipmentType;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private CharacterInventory characterInventory;

    @Override
    public void setCharacterInventory(CharacterInventory inventory) {

    }
}
