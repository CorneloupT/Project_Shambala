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

    private int goldAmount;
    private String headItem;
    private String armItem;
    private String bustItem;
    private String legItem;
    private String footItem;
    private String rightHandItem;
    private String leftHandItem;
    private List<String> bag = new ArrayList<>();

    @BeforeEach
    void setUp() {
        characterInventoryService = new CharacterInventoryServiceImpl();
        goldAmount = 158;
        headItem = "helmet";
        armItem = "armlet";
        bustItem = "breastplate";
        legItem = "legplate";
        footItem = "boots";
        rightHandItem = "sword";
        leftHandItem = "shield";
        bag = new ArrayList<>(Arrays.asList("torch", "rope"));
    }

    private CharacterInventory createInventoryTest() {
        return characterInventoryService.createCharacterInventory(goldAmount, headItem, armItem, bustItem, legItem, footItem, rightHandItem, leftHandItem, bag);
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
        assertEquals(goldAmount, characterInventoryTest.getGoldAmount());
    }

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnSameHeadItem() {
        CharacterInventory characterInventoryTest = createInventoryTest();
        assertEquals(headItem, characterInventoryTest.getHeadItem());
    }

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnSameArmItem() {
        CharacterInventory characterInventoryTest = createInventoryTest();
        assertEquals(armItem, characterInventoryTest.getArmItem());
    }

    @Test
    void testCreateCharacterInventory_whenInventoryIsProvided_shouldReturnSameBustItem() {
        CharacterInventory characterInventoryTest = createInventoryTest();
        assertEquals(bustItem, characterInventoryTest.getBustItem());
    }


}
