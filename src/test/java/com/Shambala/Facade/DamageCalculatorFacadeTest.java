package com.Shambala.Facade;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DamageCalculatorFacadeTest {

    private DamageCalculatorFacade damageCalculatorFacade;
    private CharacterEquipmentBuilder characterEquipmentBuilder;

    @BeforeEach
    void setUp() {
        damageCalculatorFacade = spy(new DamageCalculatorFacade());
        characterEquipmentBuilder = mock(CharacterEquipmentBuilder.class);
    }

    @Test
    void testGetRandomValueOFDice4() {
        int randomD4Value = damageCalculatorFacade.getValueOfDice(4);
        assertTrue(randomD4Value >= 1 && randomD4Value <= 4, "la valeur du D4 est comprise entre 1 et 4");
    }

    @Test
    void testGetRandomValueOfDice6() {
        int randomD6Value = damageCalculatorFacade.getValueOfDice(6);
        assertTrue(randomD6Value >= 1 && randomD6Value <= 6, "la valeur du D6 est comprise entre 1 et 6");
    }

    @Test
    void testGetRandomValueOfDice8() {
        int randomD8Value = damageCalculatorFacade.getValueOfDice(8);
        assertTrue(randomD8Value >= 1 && randomD8Value <= 8, "la valeur du D8 est comprise entre 1 et 8");
    }

    @Test
    void testGetRandomValueOfDice10() {
        int randomD10Value = damageCalculatorFacade.getValueOfDice(10);
        assertTrue(randomD10Value >= 1 && randomD10Value <= 10, "la valeur du D10 est comprise entre 1 et 10");
    }

    @Test
    void testGetRandomValueOfDice12() {
        int randomD12Value = damageCalculatorFacade.getValueOfDice(12);
        assertTrue(randomD12Value >= 1 && randomD12Value <= 12, "la valeur du D12 est comprise entre 1 et 12");
    }

    @Test
    void testGetBonusDamageOfNoviceOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int oneHandDamage = damageCalculatorFacade.getOneHandDamage(characterEquipmentBuilder);
        assertEquals(-1, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfApprenticeOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int oneHandDamage = damageCalculatorFacade.getOneHandDamage(characterEquipmentBuilder);
        assertEquals(0, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfConfirmedOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int oneHandDamage = damageCalculatorFacade.getOneHandDamage(characterEquipmentBuilder);
        assertEquals(1, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfMasterOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int oneHandDamage = damageCalculatorFacade.getOneHandDamage(characterEquipmentBuilder);
        assertEquals(2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfGrandMasterOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int oneHandDamage = damageCalculatorFacade.getOneHandDamage(characterEquipmentBuilder);
        assertEquals(3, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfNoviceTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int oneHandDamage = damageCalculatorFacade.getTwoHandDamage(characterEquipmentBuilder);
        assertEquals(-2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfApprenticeTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int oneHandDamage = damageCalculatorFacade.getTwoHandDamage(characterEquipmentBuilder);
        assertEquals(0, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfConfirmedTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int oneHandDamage = damageCalculatorFacade.getTwoHandDamage(characterEquipmentBuilder);
        assertEquals(2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfMasterTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int oneHandDamage = damageCalculatorFacade.getTwoHandDamage(characterEquipmentBuilder);
        assertEquals(3, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfGrandMasterTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int oneHandDamage = damageCalculatorFacade.getTwoHandDamage(characterEquipmentBuilder);
        assertEquals(4, oneHandDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(4 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityApprenticeIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(5 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityConfirmedIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(6 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(7 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityGrandMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(8 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(3 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityApprenticeIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(5 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityConfirmedIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(7 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityMasterIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(8 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityGrandMasterIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder,  EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(9 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenOneHandWeaponNoviceQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamageReduction = damageCalculatorFacade.calculateDamageReductionWithArmor(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(5 , resultDamageReduction);
    }

    @Test
    void testGetBonusReductionFromArmor_Negative1WhenNovice() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int armorProtection = damageCalculatorFacade.getArmorProtection(characterEquipmentBuilder);
        assertEquals(-1, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_0WhenApprentice() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int armorProtection = damageCalculatorFacade.getArmorProtection(characterEquipmentBuilder);
        assertEquals(0, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_0WhenConfirmed() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int armorProtection = damageCalculatorFacade.getArmorProtection(characterEquipmentBuilder);
        assertEquals(0, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_1WhenMaster() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int armorProtection = damageCalculatorFacade.getArmorProtection(characterEquipmentBuilder);
        assertEquals(1, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_2WhenGrandMaster() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int armorProtection = damageCalculatorFacade.getArmorProtection(characterEquipmentBuilder);
        assertEquals(2, armorProtection);
    }



}
