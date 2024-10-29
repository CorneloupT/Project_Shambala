package com.Shambala.models;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipementBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterEquipmentTest {

    private String name;
    private String description;
    private EquipmentType equipmentType;
    private MaterialType materialType;
    private Quality quality;
    private int breakPoint;

    @BeforeEach
    void setUp() {
        name = "bow";
        description = "new equipment";
        equipmentType = EquipmentType.ARMOR;
        materialType = MaterialType.WHITE_STEEL;
        quality = Quality.NOVICE;
        breakPoint = 60;
    }

    private record testBuilder(
            String getName,
            String getDescription,
            EquipmentType getEquipmentType,
            MaterialType getMaterialType,
            Quality getQuality,
            int getBreakPoint) implements CharacterEquipementBuilder {

    }

    private CharacterEquipementBuilder createEquipementTest() {
        return new testBuilder(name, description, equipmentType, materialType, quality, breakPoint);
    }

    @Test
    void testCreateNewEquipmentForCharacter_shouldCreateEquipmentFromBuilder() {
        CharacterEquipment characterEquipement = CharacterEquipment.
                fromEquipementBuilder(new testBuilder(
                        "bow",
                        "nice bow",
                        EquipmentType.ARMOR,
                        MaterialType.WHITE_STEEL,
                        Quality.NOVICE,
                        40));
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

    @Test
    void testCreateNewEquipmentQuality_shouldReturnEquipmentQuality() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(quality, equipmentTest.getQuality());
    }

    @Test
    void testCreateNewEquipmentBreakPoint_shouldReturnBreakPoint() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(breakPoint, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipmentType_shouldReturnType() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(equipmentType, equipmentTest.getEquipmentType());
    }

    @Test
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint60WithTypeWeapon() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipementBuilder(createEquipementTest());
        assertEquals(60, equipmentTest.getBreakPoint());
    }


}
