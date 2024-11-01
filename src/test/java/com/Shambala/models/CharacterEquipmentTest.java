package com.Shambala.models;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
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
        breakPoint = 75;
    }

    private record testBuilder(
            String getName,
            String getDescription,
            EquipmentType getEquipmentType,
            MaterialType getMaterialType,
            Quality getQuality,
            int getBreakPoint) implements CharacterEquipmentBuilder {

    }

    private CharacterEquipmentBuilder createEquipmentTest() {
        return new testBuilder(name, description, equipmentType, materialType, quality, breakPoint);
    }

    @Test
    void testCreateNewEquipmentForCharacter_shouldCreateEquipmentFromBuilder() {
        CharacterEquipment characterEquipment = CharacterEquipment.
                fromEquipmentBuilder(new testBuilder(
                        "bow",
                        "nice bow",
                        EquipmentType.ARMOR,
                        MaterialType.WHITE_STEEL,
                        Quality.NOVICE,
                        75));
        assertNotNull(characterEquipment);
    }

    @Test
    void testCreateNewEquipmentName_shouldReturnEquipmentName() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(name, equipmentTest.getName());
    }

    @Test
    void testCreateNewEquipmentDescription_shouldReturnEquipmentDescription() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(description, equipmentTest.getDescription());
    }

    @Test
    void testCreateNewEquipmentMaterialType_shouldReturnEquipmentMaterialType() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(materialType, equipmentTest.getMaterialType());
    }

    @Test
    void testCreateNewEquipmentQuality_shouldReturnEquipmentQuality() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(quality, equipmentTest.getQuality());
    }

    @Test
    void testCreateNewEquipmentBreakPoint_shouldReturnBreakPoint() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(breakPoint, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipmentType_shouldReturnType() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(equipmentType, equipmentTest.getEquipmentType());
    }

    @Test
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint60WithTypeWeapon() {
        equipmentType = EquipmentType.WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(60, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityApprenticeIsProvided_returnBreakPoint40WithTypeWeapon() {
        quality = Quality.APPRENTICE;
        equipmentType = EquipmentType.WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(40, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityConfirmedIsProvided_returnBreakPoint25WithTypeWeapon() {
        quality = Quality.CONFIRMED;
        equipmentType = EquipmentType.WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(25, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityMasterIsProvided_returnBreakPoint10WithTypeWeapon() {
        quality = Quality.MASTER;
        equipmentType = EquipmentType.WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(10, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityGrandMasterIsProvided_returnBreakPoint2WithTypeWeapon() {
        quality = Quality.GRAND_MASTER;
        equipmentType = EquipmentType.WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(2, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint75WithTypeArmor() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(75, equipmentTest.getBreakPoint());
    }
}
