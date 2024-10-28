package com.Shambala.models.export;

import com.Shambala.Enum.StatType;
import com.Shambala.models.CharacterSubStats;

import java.util.List;

public interface CharacterPrincipalStatExport {

    void setType(StatType statType);

    void setValue(int value);

    void setListSubStat(List<CharacterSubStats> subStatsList);
}
