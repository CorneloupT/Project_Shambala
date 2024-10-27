package com.Shambala.models.builder;

import com.Shambala.Enum.StatType;

public interface CharacterSubStatsBuilder {

    StatType getStatType();

    String getSubStatName();

    int getSubStatValue();

    String getDescription();
}
