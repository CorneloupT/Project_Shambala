package com.Shambala.models;

import com.Shambala.Enum.MaterialType;
import com.Shambala.models.builder.CharacterEquipementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterEquipementTest {

    private String name;
    private String description;
    private MaterialType materialType;

    @BeforeEach
    void setUp() {
        name = "bow";
        description = "new equipment";
        materialType = MaterialType.WHITE_STEEL;
    }

    private record testBuilder(String getName, String getDescription, MaterialType getMaterialType) implements CharacterEquipementBuilder {

    }

    private CharacterEquipementBuilder createEquipementTest() {
        return new testBuilder(name, description, materialType);
    }

    @Test
    void testCreateNewEquipmentForCharacter_shouldCreateEquipmentFromBuilder() {
        CharacterEquipment characterEquipement = CharacterEquipment.fromEquipementBuilder(new testBuilder("bow", "nice bow", MaterialType.WHITE_STEEL));
        assertNotNull(characterEquipement);
    }

    @Test
    void testCreateNewEquipmentName_shouldReturnEquipmentName() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(name, equipmentTest.getName());
    }

    @Test
    void testCreateNewEquipmentDescription_shouldReturnEquipmentDescription() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(description, equipmentTest.getDescription());
    }

    @Test
    void testCreateNewEquipmentMaterialType_shouldReturnEquipmentMaterialType() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(materialType, equipmentTest.getMaterialType());
    }


}
