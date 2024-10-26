package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import lombok.Getter;

@Getter
public class CharacterPrincipalStat {

    private StatType statType;
    private int value;

    public static CharacterPrincipalStat fromBuilder(CharacterPrincipalStatBuilder builder) {
        CharacterPrincipalStat characterPrincipalStat = new CharacterPrincipalStat();
        characterPrincipalStat.statType = builder.getStatType();
        characterPrincipalStat.value = builder.getValue();
        characterPrincipalStat.verifyValueIsNotUnder10();
        characterPrincipalStat.verifyValueIsNotGreaterThan50();
        characterPrincipalStat.verifyValueISDivisibleBy5();
        return characterPrincipalStat;
    }

    private void verifyValueIsNotUnder10() {
        if (value < 10) {
            throw new IllegalArgumentException("Principal stat value should be greater than 10");
        }
    }

    private void verifyValueIsNotGreaterThan50() {
        if (value > 50) {
            throw new IllegalArgumentException("Principal stat value should be lesser than 50");
        }
    }

    private void verifyValueISDivisibleBy5() {
        if (value % 5 != 0) {
            throw new IllegalArgumentException("Principal stat value should be divisible by 5");
        }
    }
}
