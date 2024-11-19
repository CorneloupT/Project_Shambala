package com.Shambala.repositories.Entity;

import com.Shambala.Enum.StatType;
import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import com.Shambala.models.export.CharacterSubStatsExport;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CharacterSubStatsEntity implements CharacterSubStatsExport, CharacterSubStatsBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private StatType statType;
    private String subStatName;
    private int subStatValue;
    private String description;

    @ManyToOne
    @JoinColumn(name = "characterPrincipalStat_id")
    private CharacterPrincipalStat principalStat;

    public CharacterSubStats toCharacterSubStatsModel() {
        return CharacterSubStats.fromSubStatBuilder(this);
    }

    @Override
    public void setType(StatType statType) {

    }
}
