package com.Shambala.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.Shambala.models.builder.CharacterInventoryBuilder;
import com.Shambala.models.export.CharacterInventoryExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterInventoryTest {

    private List<CharacterEquipment> characterEquipment;
    private List<String> bag;
    private int goldAmount;

    @BeforeEach
    void setUp() {
        characterEquipment = new ArrayList<>();
        bag = new ArrayList<>();
        goldAmount = 100;
    }

    private record InnerBuilder(List<CharacterEquipment> getCharacterEquipment, List<String> getBag, int getGoldAmount) implements CharacterInventoryBuilder {

    }

    private CharacterInventoryBuilder createTestInventory() {
        return new InnerBuilder(characterEquipment, bag, goldAmount);
    }

    @Test
    void testCreateCharacterInventory_returnCharacterInventory() {
        CharacterInventory characterInventory = CharacterInventory.fromInventoryBuilder(new InnerBuilder(characterEquipment, bag, goldAmount));
        assertNotNull(characterInventory);
    }

    @Test
    void testCreateCharacterInventory_whenListOfEquipmentIsProvided_returnEquipments() {
        CharacterInventory characterInventory = CharacterInventory.fromInventoryBuilder(createTestInventory());
        assertEquals(characterEquipment, characterInventory.getCharacterEquipment());
    }

    @Test
    void testCreateCharacterInventory_whenListOfItemsIsProvided_returnItems() {
        CharacterInventory characterInventory = CharacterInventory.fromInventoryBuilder(createTestInventory());
        assertEquals(bag, characterInventory.getBag());
    }

    @Test
    void testCreateCharacterInventory_whenAmountOfGoldIsProvided_returnAmountOfGold() {
        CharacterInventory characterInventory = CharacterInventory.fromInventoryBuilder(createTestInventory());
        assertEquals(goldAmount, characterInventory.getGoldAmount());
    }

    @Test
    void shouldExportCharacterInventoryValues() {
        CharacterInventoryExport inventoryExport = mock(CharacterInventoryExport.class);
        CharacterInventory characterInventory = CharacterInventory.fromInventoryBuilder(createTestInventory());
        characterInventory.exportInventory(inventoryExport);

        verify(inventoryExport).setCharacterEquipment(eq(characterEquipment));
        verify(inventoryExport).setBag(eq(bag));
        verify(inventoryExport).setGoldAmount(eq(goldAmount));
    }

}
