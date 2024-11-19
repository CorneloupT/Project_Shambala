package com.Shambala.models.builder;

import com.Shambala.Enum.StatType;
import com.Shambala.models.CharacterPrincipalStat;

public interface CharacterSubStatsBuilder {

    StatType getStatType();

    String getSubStatName();

    int getSubStatValue();

    String getDescription();

    long getId();

    CharacterPrincipalStat getPrincipalStat();
}
