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
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.ONEHAND_WEAPON);
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
    void testDamageCalculator_WhenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentOneHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(4 , resultDamage);
    }

    @Test
    void testDamageCalculator_WhenEquipmentQualityApprenticeIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentOneHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(5 , resultDamage);
    }

    @Test
    void testDamageCalculator_WhenEquipmentQualityConfirmedIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentOneHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(6 , resultDamage);
    }

    @Test
    void testDamageCalculator_WhenEquipmentQualityMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentOneHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(7 , resultDamage);
    }

    @Test
    void testDamageCalculator_WhenEquipmentQualityGrandMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(damageCalculatorFacade.getValueOfDice(6)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentOneHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(8 , resultDamage);
    }

    @Test
    void testDamageCalculator_WhenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(damageCalculatorFacade.getValueOfDice(8)).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateRollDamageWithDifferentTwoHandWeaponQuality(characterEquipmentBuilder, 6);
        assertEquals(3 , resultDamage);
    }

}
