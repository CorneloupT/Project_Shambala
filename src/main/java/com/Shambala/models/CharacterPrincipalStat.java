package com.Shambala.models;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;

public class CharacterPrincipalStat {

    private int physical;

    public static CharacterPrincipalStat fromBuilder(CharacterPrincipalStatBuilder builder) {
        CharacterPrincipalStat characterPrincipalStat = new CharacterPrincipalStat();
        characterPrincipalStat.physical = builder.getPhysical();
        return characterPrincipalStat;
    }
}
