package com.Shambala.Service;

import com.Shambala.models.CharacterInventory;

import java.util.List;

public interface CharacterInventoryService {

    CharacterInventory createCharacterInventory(int gold,
                                                String head,
                                                String arm,
                                                String bust,
                                                String leg,
                                                String foot,
                                                String rightHand,
                                                String leftHand,
                                                List<String> bag);
}
