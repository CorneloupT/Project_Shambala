package com.Shambala.repositories.Entity;

import com.Shambala.Enum.StatType;
import com.Shambala.models.Character;
import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.export.CharacterPrincipalStatExport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CharacterPrincipalStatEntity implements CharacterPrincipalStatExport, CharacterPrincipalStatBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private StatType statType;
    private int value;

    @OneToMany(mappedBy = "characterPrincipalStat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterSubStats> subStatsList;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    private CharacterPrincipalStat toPrincipalStatModel() {
        return CharacterPrincipalStat.fromBuilder(this);
    }

    @Override
    public void setType(StatType statType) {

    }

    @Override
    public void setListSubStat(List<CharacterSubStats> subStatsList) {

    }
}
