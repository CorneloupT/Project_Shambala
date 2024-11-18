package com.Shambala.models;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.MaterialType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
import com.Shambala.models.export.CharacterEquipmentExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharacterEquipmentTest {

    private long id;
    private String name;
    private String description;
    private EquipmentType equipmentType;
    private MaterialType materialType;
    private Quality quality;
    private int breakPoint;

    @BeforeEach
    void setUp() {
        id = 1L;
        name = "bow";
        description = "new equipment";
        equipmentType = EquipmentType.ARMOR;
        materialType = MaterialType.WHITE_STEEL;
        quality = Quality.NOVICE;
        breakPoint = 75;
    }

    private record testBuilder(
            long getId,
            String getName,
            String getDescription,
            EquipmentType getEquipmentType,
            MaterialType getMaterialType,
            Quality getQuality,
            int getBreakPoint) implements CharacterEquipmentBuilder {

    }

    private CharacterEquipmentBuilder createEquipmentTest() {
        return new testBuilder(id, name, description, equipmentType, materialType, quality, breakPoint);
    }

    @Test
    void testCreateNewEquipmentForCharacter_shouldCreateEquipmentFromBuilder() {
        CharacterEquipment characterEquipment = CharacterEquipment.
                fromEquipmentBuilder(new testBuilder(
                        1L,
                        "bow",
                        "nice bow",
                        EquipmentType.ARMOR,
                        MaterialType.WHITE_STEEL,
                        Quality.NOVICE,
                        75));
        assertNotNull(characterEquipment);
    }

    @Test
    void testCreateNewEquipmentName_whenIdIsProvided_shouldReturnId() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(id, equipmentTest.getId());
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
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint60WithTypeOneHandWeapon() {
        equipmentType = EquipmentType.ONEHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(60, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityApprenticeIsProvided_returnBreakPoint40WithTypeOneHandWeapon() {
        quality = Quality.APPRENTICE;
        equipmentType = EquipmentType.ONEHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(40, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityConfirmedIsProvided_returnBreakPoint25WithTypeOneHandWeapon() {
        quality = Quality.CONFIRMED;
        equipmentType = EquipmentType.ONEHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(25, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityMasterIsProvided_returnBreakPoint10WithTypeOneHandWeapon() {
        quality = Quality.MASTER;
        equipmentType = EquipmentType.ONEHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(10, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityGrandMasterIsProvided_returnBreakPoint2WithTypeOneHandWeapon() {
        quality = Quality.GRAND_MASTER;
        equipmentType = EquipmentType.ONEHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(2, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint60WithTypeTwoHandWeapon() {
        equipmentType = EquipmentType.TWOHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(60, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityApprenticeIsProvided_returnBreakPoint40WithTypeTwoHandWeapon() {
        quality = Quality.APPRENTICE;
        equipmentType = EquipmentType.TWOHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(40, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityConfirmedIsProvided_returnBreakPoint25WithTypeTwoHandWeapon() {
        quality = Quality.CONFIRMED;
        equipmentType = EquipmentType.TWOHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(25, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityMasterIsProvided_returnBreakPoint10WithTypeTwoHandWeapon() {
        quality = Quality.MASTER;
        equipmentType = EquipmentType.TWOHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(10, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityGrandMasterIsProvided_returnBreakPoint2WithTypeTwoHandWeapon() {
        quality = Quality.GRAND_MASTER;
        equipmentType = EquipmentType.TWOHAND_WEAPON;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(2, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityNoviceIsProvided_returnBreakPoint75WithTypeArmor() {
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(75, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityApprenticeIsProvided_returnBreakPoint50WithTypeArmor() {
        quality = Quality.APPRENTICE;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(50, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityConfirmedIsProvided_returnBreakPoint35WithTypeArmor() {
        quality = Quality.CONFIRMED;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(35, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityMasterIsProvided_returnBreakPoint15WithTypeArmor() {
        quality = Quality.MASTER;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(15, equipmentTest.getBreakPoint());
    }

    @Test
    void testCreateNewEquipment_whenQualityGrandMasterIsProvided_returnBreakPoint5WithTypeArmor() {
        quality = Quality.GRAND_MASTER;
        CharacterEquipment equipmentTest = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        assertEquals(5, equipmentTest.getBreakPoint());
    }

    @Test
    void shouldExportCharacterEquipmentValues() {
        CharacterEquipmentExport characterEquipmentExport = mock(CharacterEquipmentExport.class);
        CharacterEquipment equipment = CharacterEquipment.fromEquipmentBuilder(createEquipmentTest());
        equipment.exportEquipment(characterEquipmentExport);

        verify(characterEquipmentExport).setName("bow");
        verify(characterEquipmentExport).setDescription("new equipment");
        verify(characterEquipmentExport).setEquipmentType(EquipmentType.ARMOR);
        verify(characterEquipmentExport).setMaterialType(MaterialType.WHITE_STEEL);
        verify(characterEquipmentExport).setQuality(Quality.NOVICE);
        verify(characterEquipmentExport).setBreakPoint(75);
    }
}
