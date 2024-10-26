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
        return characterPrincipalStat;
    }

    private void verifyValueIsNotUnder10() {
        if (value < 10) {
            throw new IllegalArgumentException("Principal stat value should be greater than 10");
        }
    }
}
