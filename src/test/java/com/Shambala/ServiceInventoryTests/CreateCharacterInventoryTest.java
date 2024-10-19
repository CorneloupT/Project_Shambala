package com.Shambala.ServiceInventoryTests;

import com.Shambala.Service.CharacterInventoryService;
import com.Shambala.Service.ServiceImpl.CharacterInventoryServiceImpl;
import com.Shambala.models.CharacterInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCharacterInventoryTest {

    private CharacterInventoryService characterInventoryService;

    private int gold;
    private String head;
    private String arm;
    private String bust;
    private String leg;
    private String foot;
    private String rightHand;
    private String leftHand;
    private List<String> bag = new ArrayList<>();

    @BeforeEach
    void setUp() {
        characterInventoryService = new CharacterInventoryServiceImpl();
        gold = 158;
        head = "helmet";
        arm = "armlet";
        bust = "breastplate";
        leg = "legplate";
        foot = "boots";
        rightHand = "sword";
        leftHand = "shield";
        bag = new ArrayList<>(Arrays.asList("torch", "rope"));
    }

    private CharacterInventory createInventoryTest() {
        return characterInventoryService.createCharacterInventory(gold, head, arm, bust, leg, foot, rightHand, leftHand, bag);
    }

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnAllInventory() {
        //Act
        CharacterInventory characterInventoryTest = createInventoryTest();
        //Assert
        assertNotNull(characterInventoryTest, "createCharacterInventory method should not return null");
    }

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnSameMountOfGold() {
        CharacterInventory characterInventoryTest = createInventoryTest();
        assertEquals(gold, characterInventoryTest.getGold());
    }

}
