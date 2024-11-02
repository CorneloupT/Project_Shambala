package com.Shambala.Facade;

import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;

public class DamageCalculatorFacade {

    public int rollDamageDice(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public int getValueOfDice(int sides) {
        return rollDamageDice(sides);
    }

    public int getModifierQualityWithOneHandWeapon(Quality quality) {
        return switch (quality) {
            case NOVICE -> -1;
            case APPRENTICE -> 0;
            case CONFIRMED -> 1;
            case MASTER -> 2;
            case GRAND_MASTER -> 3;
        };
    }

    private int getModifierQualityWithTwoHandWeapon(Quality quality) {
        return switch (quality) {
            case NOVICE -> -2;
            case APPRENTICE -> 0;
            case CONFIRMED -> 2;
            case MASTER -> 3;
            case GRAND_MASTER -> 4;
        };
    }

    public int calculateRollDamageWithDifferentOneHandWeaponQuality(CharacterEquipmentBuilder characterEquipmentBuilder, int diceSides) {
            Quality quality = characterEquipmentBuilder.getQuality();
            int modifier = getModifierQualityWithOneHandWeapon(quality);
            int rolledValue = getValueOfDice(diceSides);
            return rolledValue + modifier;
    }

    public int calculateRollDamageWithDifferentTwoHandWeaponQuality(CharacterEquipmentBuilder characterEquipmentBuilder, int diceSides) {
        Quality quality = characterEquipmentBuilder.getQuality();
        int modifier = getModifierQualityWithTwoHandWeapon(quality);
        int rolledValue = getValueOfDice(diceSides);
        return rolledValue + modifier;
    }

}
