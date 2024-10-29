package com.Shambala.models;

import com.Shambala.models.builder.CharacterEquipementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterEquipementTest {

    private String name;

    @BeforeEach
    void setUp() {
        name = "bow";
    }

    private record testBuilder(String getName) implements CharacterEquipementBuilder {

    }

    private CharacterEquipementBuilder createEquipementTest() {
        return new testBuilder(name);
    }

    @Test
    void testCreateNewEquipmentForCharacter_shouldCreateEquipmentFromBuilder() {
        CharacterEquipement characterEquipement = CharacterEquipement.fromEquipementBuilder(new testBuilder("bow"));
        assertNotNull(characterEquipement);

    }

    @Test
    void testCreateNewEquipmentName_shouldReturnEquipmentName() {
        CharacterEquipement equipmentTest = CharacterEquipement.fromEquipementBuilder(createEquipementTest());
        assertEquals(name, equipmentTest.getName());
    }


}
