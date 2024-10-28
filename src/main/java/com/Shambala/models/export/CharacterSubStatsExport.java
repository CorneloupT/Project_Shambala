package com.Shambala.models.export;

import com.Shambala.Enum.StatType;

public interface CharacterSubStatsExport {

    void setType(StatType statType);

    void setSubStatName(String subStatName);

    void setSubStatValue(int subStatValue);

    void setDescription(String description);
}
