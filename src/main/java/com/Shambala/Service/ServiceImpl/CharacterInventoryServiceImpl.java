package com.Shambala.Service.ServiceImpl;

import com.Shambala.Service.CharacterInventoryService;
import com.Shambala.models.CharacterInventory;

import java.util.List;

public class CharacterInventoryServiceImpl implements CharacterInventoryService {

    @Override
    public CharacterInventory createCharacterInventory(int gold,
                                                       String head,
                                                       String arm,
                                                       String bust,
                                                       String leg,
                                                       String foot,
                                                       String rightHand,
                                                       String leftHand,
                                                       List<String> bag) {

        return new CharacterInventory(gold, head, arm, bust, leg, foot, rightHand, leftHand, bag);
    }
}
