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
    private String legItem;
    private String footItem;
    private String rightHandItem;
    private String leftHandItem;
    private List<String> bag;


}
