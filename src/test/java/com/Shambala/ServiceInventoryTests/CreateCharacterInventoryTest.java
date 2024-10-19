package com.Shambala.ServiceInventoryTests;

import com.Shambala.Service.CharacterInventoryService;
import com.Shambala.Service.ServiceImpl.CharacterInventoryServiceImpl;
import com.Shambala.models.CharacterInventory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        CharacterInventory characterInventoryTest = characterInventoryService.createCharacterInventory(gold, head, arm, bust, leg, foot, rightHand, leftHand, bag);

        //Assert
        assertNotNull(characterInventoryTest, "createCharacterInventory method should not return null");
    }

}
