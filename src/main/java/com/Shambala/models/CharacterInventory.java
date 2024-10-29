package com.Shambala.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInventory {

    private List<CharacterEquipement> characterEquipement;
    private List<String> bag;
    private int goldAmount;


}
