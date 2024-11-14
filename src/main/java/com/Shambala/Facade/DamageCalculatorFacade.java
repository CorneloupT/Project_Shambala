package com.Shambala.Facade;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.CharacterEquipment;

public class DamageCalculatorFacade {

     private final DiceRoll diceRoll;

     public DamageCalculatorFacade(DiceRoll diceRoll) {
         this.diceRoll = diceRoll;
     }

    int rollDamageDice(int sides) {
        return diceRoll.roll(sides);
    }

    public int getModifierQuality(Quality quality, EquipmentType equipmentType) {
        return switch (equipmentType) {
            case ARMOR -> switch (quality) {
                case NOVICE -> -1;
                case APPRENTICE, CONFIRMED -> 0;
                case MASTER -> 1;
                case GRAND_MASTER -> 2;
            };
            case ONEHAND_WEAPON -> switch (quality) {
                case NOVICE -> -1;
                case APPRENTICE -> 0;
                case CONFIRMED -> 1;
                case MASTER -> 2;
                case GRAND_MASTER -> 3;
            };
            case TWOHAND_WEAPON -> switch (quality) {
                case NOVICE -> -2;
                case APPRENTICE -> 0;
                case CONFIRMED -> 2;
                case MASTER -> 3;
                case GRAND_MASTER -> 4;
            };
        };
    }

    public int getModifier(CharacterEquipment characterEquipment, EquipmentType equipmentType) {
        Quality quality = characterEquipment.getQuality();
        return getModifierQuality(quality, equipmentType);
    }

    public int calculateDamageWithWeaponModifier(CharacterEquipment characterEquipment, EquipmentType equipmentType, int diceSides) {
        int modifier = getModifier(characterEquipment, equipmentType);
        int rolledValue = diceRoll.roll(diceSides);
        return rolledValue + modifier;
    }

    public int calculateDamageReductionWithArmorModifier(CharacterEquipment characterEquipment, EquipmentType equipmentType) {
        int damage =  calculateDamageWithWeaponModifier(characterEquipment, equipmentType, 8);
        Quality quality = characterEquipment.getQuality();
        return damage - getModifierQuality(quality, EquipmentType.ARMOR);
    }

}
