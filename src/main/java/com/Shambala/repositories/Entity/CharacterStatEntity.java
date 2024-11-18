package com.Shambala.repositories.Entity;

import com.Shambala.models.Character;
import com.Shambala.models.CharacterStats;
import com.Shambala.models.builder.CharacterStatsBuilder;
import com.Shambala.models.export.CharacterStatsExport;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CharacterStatEntity implements CharacterStatsExport, CharacterStatsBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int lifePoints;
    private int lifePointsMax;
    private int ENPoints;
    private int ENPointsMax;
    private int luckyPoints;
    private int protection;
    private Character character;

    public CharacterStats toCharacterStatsModel() {
        return CharacterStats.fromStatBuilder(this);
    }

}
