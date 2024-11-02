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

    public int calculateRollDamageWithNoviceEquipment(CharacterEquipmentBuilder characterEquipmentBuilder, int diceSides, int modifier) {
        if (characterEquipmentBuilder.getQuality().equals(Quality.NOVICE)) {
            int rolledValue = getValueOfDice(diceSides);
            return rolledValue + modifier;
        }
        return modifier;
    }

    public int calculateRollDamageWithApprenticeEquipment(CharacterEquipmentBuilder characterEquipmentBuilder, int diceSides, int modifier) {
        if (characterEquipmentBuilder.getQuality().equals(Quality.APPRENTICE)) {
            int rolledValue = getValueOfDice(diceSides);
            return rolledValue + modifier;
        }
        return modifier;
    }
}
