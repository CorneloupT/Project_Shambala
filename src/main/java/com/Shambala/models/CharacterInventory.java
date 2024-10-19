package com.Shambala.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInventory {

    private int goldAmount;
    private String headItem;
    private String armItem;
    private String bustItem;


}
