package com.Shambala.models.builder;

import com.Shambala.Enum.StatType;
import com.Shambala.models.Character;
import com.Shambala.models.CharacterSubStats;

import java.util.List;

public interface CharacterPrincipalStatBuilder {
    StatType getStatType();
    int getValue();
    List<CharacterSubStats> getSubStatsList();
    Character getCharacter();
}
