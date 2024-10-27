package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class CharacterPrincipalStat {

    private StatType statType;
    private int value;
    private List<CharacterSubStats> subStatsList;

    public static CharacterPrincipalStat fromBuilder(CharacterPrincipalStatBuilder builder) {
        CharacterPrincipalStat characterPrincipalStat = new CharacterPrincipalStat();
        characterPrincipalStat.statType = builder.getStatType();
        characterPrincipalStat.value = builder.getValue();
        characterPrincipalStat.subStatsList = builder.getSubStatsList();
        characterPrincipalStat.verifyValue();
        return characterPrincipalStat;
    }

    private void verifyValue() {
        if (value < 10 || value > 50 || value % 5 != 0) {
            throw new IllegalArgumentException("Principal stat value should be greater than 10, lesser than 50 and divisible by 5");
        }
    }

}
