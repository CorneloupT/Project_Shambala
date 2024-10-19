package com.Shambala.Service;

import com.Shambala.models.CharacterInventory;

import java.util.List;

public interface CharacterInventoryService {

    CharacterInventory createCharacterInventory(int goldAmount,
                                                String headItem,
                                                String armItem,
                                                String bustItem,
                                                String legItem,
                                                String footItem,
                                                String rightHandItem,
                                                String leftHandItem,
                                                List<String> bag);
}
