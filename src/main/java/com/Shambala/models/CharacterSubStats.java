package com.Shambala.models;

import com.Shambala.Enum.StatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSubStats {

    private String subStatName;
    private int subStatValue;
    private StatType statType;
}
