package com.Shambala.Facade;

import com.Shambala.Enum.EquipmentType;
import com.Shambala.Enum.Quality;
import com.Shambala.models.CharacterEquipment;
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
            case ARMOR -> switch (quality) {
                case NOVICE -> -1;
                case APPRENTICE -> 0;
                case CONFIRMED -> 0;
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

    public int getOneHandDamage(CharacterEquipmentBuilder characterEquipmentBuilder) {
        Quality quality = characterEquipmentBuilder.getQuality();
        return getModifierQuality(quality, EquipmentType.ONEHAND_WEAPON);
    }

    public int getTwoHandDamage(CharacterEquipmentBuilder characterEquipmentBuilder) {
        Quality quality = characterEquipmentBuilder.getQuality();
        return getModifierQuality(quality, EquipmentType.TWOHAND_WEAPON);
    }

    public int getArmorProtection(CharacterEquipmentBuilder characterEquipmentBuilder) {
        Quality quality = characterEquipmentBuilder.getQuality();
        return getModifierQuality(quality, EquipmentType.ARMOR);
    }

    public int calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(CharacterEquipmentBuilder characterEquipmentBuilder, EquipmentType equipmentType, int diceSides) {
        Quality quality = characterEquipmentBuilder.getQuality();
        int modifier = getModifierQuality(quality, equipmentType);
        int rolledValue = getValueOfDice(diceSides);
        return rolledValue + modifier;
    }

    public int calculateDamageReductionWithArmor(CharacterEquipmentBuilder characterEquipmentBuilder, EquipmentType equipmentType) {
        Quality quality = characterEquipmentBuilder.getQuality();
        int damage = calculateDamageWithDifferentEquipmentTypeAndWeaponQuality(characterEquipmentBuilder, equipmentType, 8);
        int reductionDamage = getModifierQuality(quality, EquipmentType.ARMOR);
        return damage - reductionDamage;
    }

}
