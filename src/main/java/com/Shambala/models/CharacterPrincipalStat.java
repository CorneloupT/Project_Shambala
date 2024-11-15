package com.Shambala.models;

import com.Shambala.Enum.StatType;
import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.export.CharacterPrincipalStatExport;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterPrincipalStat {

    private StatType statType;
    private int value;
    private List<CharacterSubStats> subStatsList;
    private Character character;

    public static CharacterPrincipalStat fromBuilder(CharacterPrincipalStatBuilder builder) {
        CharacterPrincipalStat characterPrincipalStat = new CharacterPrincipalStat();
        characterPrincipalStat.statType = builder.getStatType();
        characterPrincipalStat.value = builder.getValue();
        characterPrincipalStat.subStatsList = builder.getSubStatsList();
        characterPrincipalStat.character = builder.getCharacter();
        characterPrincipalStat.verifyValue();
        characterPrincipalStat.verifyListOfSubStat();
        return characterPrincipalStat;
    }

    private void verifyValue() {
        if (value < 10 || value > 50 || value % 5 != 0) {
            throw new IllegalArgumentException("Principal stat value should be greater than 10, lesser than 50 and divisible by 5");
        }
    }

    private void verifyListOfSubStat() {
        for (CharacterSubStats subStats : subStatsList) {
            if (subStats.getStatType() != statType) {
                throw new IllegalArgumentException("All sub Stat should be have same type than principal Stat");
            }
        }
    }

    public void addNewSubStatWithNoDuplicationNameAndSizeLimit(CharacterSubStats subStats) {
        boolean isSubStatAlreadyPresent = subStatsList.stream().anyMatch(stat -> stat.getSubStatName().equals(subStats.getSubStatName()));
        if (isSubStatAlreadyPresent || subStatsList.size() != 20) {
            throw new RuntimeException("SubStat can't be duplicate and the list should contains 20 sub stats");
        }
        subStatsList.add(subStats);
    }

    public void completeListOfSubStatForAllPrincipalStat() {
        for (StatType statType : StatType.values()) {
            long allSubStat = subStatsList
                    .stream()
                    .filter(subStat -> subStat.getStatType().equals(statType))
                    .count();

            if (allSubStat > 4) {
                throw new ArrayIndexOutOfBoundsException("list is not complete");
            }

            while (allSubStat < 4) {
                CharacterSubStats subStat = new CharacterSubStats();
                subStatsList.add(subStat);
                allSubStat++;
            }
        }

    }

    public void exportTo(CharacterPrincipalStatExport principalStatExport) {
        principalStatExport.setType(statType);
        principalStatExport.setValue(value);
        principalStatExport.setListSubStat(subStatsList);
    }

}
