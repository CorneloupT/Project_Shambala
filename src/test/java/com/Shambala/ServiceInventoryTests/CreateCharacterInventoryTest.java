package com.Shambala.ServiceInventoryTests;

import com.Shambala.Service.CharacterInventoryService;
import com.Shambala.Service.ServiceImpl.CharacterInventoryServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCharacterInventoryTest {

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnAllInventory() {
        //Arrange
        CharacterInventoryService characterInventoryService = new CharacterInventoryServiceImpl();
        int gold = 158;
        String head = "helmet";
        String arm = "armlet";
        String bust = "breastplate";
        String leg = "legplate";
        String foot = "boots";
        String rightHand = "sword";
        String leftHand = "shield";
        List<String> bag = new ArrayList<>(Arrays.asList("torch", "rope"));
        //Act
        characterInventoryService.createCharacterInventory(gold, head, arm, bust, leg, foot, rightHand, leftHand, bag);

        //Assert
    }

}
