package com.Shambala.Facade;

import com.Shambala.Enum.Quality;
import com.Shambala.models.builder.CharacterEquipmentBuilder;

public class DamageCalculatorFacade {

    public int rollDamageDice(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public int getValueOfDice4() {
        return rollDamageDice(4);
    }

    public int getValueOfDice6() {
        return rollDamageDice(6);
    }

    public int getValueOfDice8() {
        return rollDamageDice(8);
    }

    public int getValueOfDice10() {
        return rollDamageDice(10);
    }

    public int getValueOfDice12() {
        return rollDamageDice(12);
    }

    public int calculateRollDamageWithNoviceEquipment(CharacterEquipmentBuilder characterEquipmentBuilder, int modifier) {
        if (characterEquipmentBuilder.getQuality().equals(Quality.NOVICE)) {
            return getValueOfDice6() + modifier;
        }
        return modifier;
    }

    public int calculateRollDamageWithApprenticeEquipment(CharacterEquipmentBuilder characterEquipmentBuilder, int modifier) {
        if (characterEquipmentBuilder.getQuality().equals(Quality.APPRENTICE)) {
            return getValueOfDice8() + modifier;
        }
        return modifier;
    }
}
