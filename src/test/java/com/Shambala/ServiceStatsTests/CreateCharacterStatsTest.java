package com.Shambala.ServiceStatsTests;

import com.Shambala.Service.ServiceImpl.CharacterStatServiceImpl;
import com.Shambala.models.CharacterStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCharacterStatsTest {

    private CharacterStatService characterStatService;

    private int lifePoints;
    private int lifePointsMax;
    private int ENPoints;
    private int ENPointsMax;
    private int luckyPoints;
    private int protection;
    private int physicalStat;
    private int dexterityStat;
    private int psychicStat;
    private int willPowerStat;
    private int fightStat;

    @BeforeEach
    void Setup() {
        characterStatService = new CharacterStatServiceImpl();
        lifePoints = 12;
        lifePointsMax = 14;
        ENPoints = 3;
        ENPointsMax = 5;
        luckyPoints = 5;
        protection = 2;
        physicalStat = 40;
        dexterityStat = 30;
        psychicStat = 15;
        willPowerStat = 30;
        fightStat = 35;
    }

    private CharacterStats createCharacterStats() {
        return characterStatService.createNewStats(
                lifePoints,
                lifePointsMax,
                ENPoints,
                ENPointsMax,
                luckyPoints,
                protection,
                physicalStat,
                dexterityStat,
                psychicStat,
                willPowerStat,
                fightStat);
    }

    @Test
    void testCreateCharacterStats_whenStatsAreProvided_returnAllStats() {
        //Act
        CharacterStats characterStats = createCharacterStats();
        //Assert
        assertNotNull(characterStats, "The method should not return null Stats");
    }

    @Test
    void testCreateCharacterStats_whenLifePointsAreProvided_returnLifePoints() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(lifePoints, characterStats.getLifePoints());
    }

    @Test
    void testCreateCharacterStats_whenMaxLifePointsAreProvided_returnMaxLifePoints() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(lifePointsMax, characterStats.getLifePointsMax());
    }

    @Test
    void testCreateCharacterStats_whenENPointsAreProvided_returnENPoints() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(ENPoints, characterStats.getENPoints());
    }

    @Test
    void testCreateCharacterStats_whenMaxENPointsAreProvided_returnMaxENPoints() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(lifePointsMax, characterStats.getLifePointsMax());
    }

    @Test
    void testCreateCharacterStats_whenLuckyPointAreProvided_returnMaxLuckyPoint() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(luckyPoints, characterStats.getLuckyPoints());
    }

    @Test
    void testCreateCharacterStats_whenProtectionIsProvided_returnProtection() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(protection, characterStats.getProtection());
    }

    @Test
    void testCreateCharacterStats_whenPhysicalStatIsProvided_returnPhysicalStat() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(physicalStat, characterStats.getPhysicalStat());
    }

    @Test
    void testCreateCharacterStats_whenDexterityStatIsProvided_returnDexterityStat() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(dexterityStat, characterStats.getDexterityStat());
    }

    @Test
    void testCreateCharacterStats_whenPsychicStatIsProvided_returnPsychicStat() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(psychicStat, characterStats.getPsychicStat());
    }

    @Test
    void testCreateCharacterStats_whenWillPowerStatIsProvided_returnWillPowerStat() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(willPowerStat, characterStats.getWillPowerStat());
    }

    @Test
    void testCreateCharacterStats_whenFightStatIsProvided_returnFightStat() {
        CharacterStats characterStats = createCharacterStats();
        assertEquals(fightStat, characterStats.getFightStat());
    }
}