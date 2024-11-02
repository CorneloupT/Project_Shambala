package com.Shambala.Facade;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;

public class DamageCalculatorFacade {

    public int rollDamageDice(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public int getValueOfDice(int sides) {
        return rollDamageDice(sides);
    }

    public int getModifierQuality(Quality quality, EquipmentType equipmentType) {
        return switch (equipmentType) {
            case ARMOR -> 0;
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


    public int calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(CharacterEquipmentBuilder characterEquipmentBuilder, int diceSides) {
            Quality quality = characterEquipmentBuilder.getQuality();
            EquipmentType equipmentType = characterEquipmentBuilder.getEquipmentType();
            int modifier = getModifierQuality(quality, equipmentType);
            int rolledValue = getValueOfDice(diceSides);
            return rolledValue + modifier;
    }
}
