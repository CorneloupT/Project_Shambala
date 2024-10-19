package com.Shambala.Service.ServiceImpl;

import com.Shambala.Service.CharacterInventoryService;
import com.Shambala.models.CharacterInventory;

import java.util.List;

public class CharacterInventoryServiceImpl implements CharacterInventoryService {

    @Override
    public CharacterInventory createCharacterInventory(int goldAmount,
                                                       String headItem,
                                                       String armItem,
                                                       String bustItem,
                                                       String legItem,
                                                       String footItem,
                                                       String rightHandItem,
                                                       String leftHandItem,
                                                       List<String> bag) {

        return new CharacterInventory(goldAmount, headItem, armItem, bustItem);
    }
}
