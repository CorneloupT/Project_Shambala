package com.Shambala.Facade;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ThreadLocalRandom;

public class DamageCalculatorFacadeTest {

    private DamageCalculatorFacade damageCalculatorFacade;
    private CharacterEquipmentBuilder characterEquipmentBuilder;
    private DiceRoll diceRoll;
    private DiceRoll getDiceRoll() {
        return (sides) -> ThreadLocalRandom.current().nextInt(1, sides + 1);
    }

    @BeforeEach
    void setUp() {
        damageCalculatorFacade = new DamageCalculatorFacade(getDiceRoll());
        characterEquipmentBuilder = mock(CharacterEquipmentBuilder.class);
        diceRoll = new DiceRoll();
    }

    @Test
    void testGetBonusDamageOfNoviceOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(-1, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfApprenticeOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(0, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfConfirmedOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(1, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfMasterOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfGrandMasterOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(3, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfNoviceTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(-2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfApprenticeTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(0, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfConfirmedTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(2, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfMasterTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(3, oneHandDamage);
    }

    @Test
    void testGetBonusDamageOfGrandMasterTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int oneHandDamage = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(4, oneHandDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(4 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityApprenticeIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(5 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityConfirmedIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(6 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(7 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityGrandMasterIsProvided_ReturnDamageWithModifierForOneHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON,6);
        assertEquals(8 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityNoviceIsProvided_ReturnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(3 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityApprenticeIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(5 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityConfirmedIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(7 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityMasterIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(characterEquipmentBuilder.getEquipmentType()).thenReturn(EquipmentType.TWOHAND_WEAPON);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(8 , resultDamage);
    }

    @Test
    void testDamageCalculator_whenEquipmentQualityGrandMasterIsProvided_returnDamageWithModifierForTwoHandWeapon() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamage = damageCalculatorFacade.calculateDamageWithWeaponModifier(characterEquipmentBuilder,  EquipmentType.TWOHAND_WEAPON,8);
        assertEquals(9 , resultDamage);
    }

    @Test
    void testGetBonusReductionFromArmor_Negative1WhenNovice() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        int armorProtection = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ARMOR);
        assertEquals(-1, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_0WhenApprentice() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        int armorProtection = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ARMOR);
        assertEquals(0, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_0WhenConfirmed() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        int armorProtection = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ARMOR);
        assertEquals(0, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_1WhenMaster() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        int armorProtection = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ARMOR);
        assertEquals(1, armorProtection);
    }

    @Test
    void testGetBonusReductionFromArmor_2WhenGrandMaster() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        int armorProtection = damageCalculatorFacade.getModifier(characterEquipmentBuilder, EquipmentType.ARMOR);
        assertEquals(2, armorProtection);
    }


    @Test
    void testDamageCalculator_whenOneHandWeaponNoviceQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(5 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenOneHandWeaponApprenticeQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(5 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenOneHandWeaponConfirmedQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(6 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenOneHandWeaponMasterQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(6 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenOneHandWeaponGrandMasterQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.ONEHAND_WEAPON);
        assertEquals(6 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenTwoHandWeaponNoviceQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.NOVICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(4 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenTwoHandWeaponApprenticeQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.APPRENTICE);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(5 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenTwoHandWeaponConfirmedQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.CONFIRMED);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(7 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenTwoHandWeaponMasterQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(7 , resultDamageWithReduction);
    }

    @Test
    void testDamageCalculator_whenTwoHandWeaponGrandMasterQualityIsProvided_returnDamageReductionWithArmor() {
        when(characterEquipmentBuilder.getQuality()).thenReturn(Quality.GRAND_MASTER);
        when(diceRoll.roll(Mockito.anyInt())).thenReturn(5);
        int resultDamageWithReduction = damageCalculatorFacade.calculateDamageReductionWithArmorModifier(characterEquipmentBuilder, EquipmentType.TWOHAND_WEAPON);
        assertEquals(7 , resultDamageWithReduction);
    }

}
