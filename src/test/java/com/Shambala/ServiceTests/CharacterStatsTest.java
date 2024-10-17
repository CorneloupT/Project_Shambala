package com.Shambala.ServiceTests;

import com.Shambala.Service.CharacterStatService;
import com.Shambala.Service.ServiceImpl.CharacterStatServiceImpl;
import com.Shambala.models.CharacterStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterStatsTest {

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
        characterStatService =  new CharacterStatServiceImpl();
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

    static Stream<Arguments> statsProvider() {
        return Stream.of(
                Arguments.of(10, 34, 40, 50, 20),   // premier jeu de valeurs
                Arguments.of(5, 20, 30, 40, 50),  // second jeu de valeurs
                Arguments.of(10, 20, 30, 40, 70)        // troisième jeu de valeurs
        );
    }

    @ParameterizedTest
    @MethodSource("statsProvider")
    void testVerifyPrincipalCharacterStats_WhenPrincipalsStatsAreProvided_ShouldBeSupTo50_InfTo10_DivisibleBy5(int physicalStat, int dexterityStat, int psychicStat, int willPowerStat, int fightStat) {
        // Créez une instance de CharacterStats et affectez les valeurs.
        CharacterStats principalStats = new CharacterStats();
        principalStats.setPhysicalStat(physicalStat);
        principalStats.setDexterityStat(dexterityStat);
        principalStats.setPsychicStat(psychicStat);
        principalStats.setWillPowerStat(willPowerStat);
        principalStats.setFightStat(fightStat);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.verifyPrincipalCharacterStats(principalStats));
        assertEquals("Principal Stat should not be superior to 50, inferior to 10 and divisible by 5", exception.getMessage());
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

    @ParameterizedTest
    @ValueSource(ints = {5, 34, 70})
    void testCreateCharacterStats_whenPhysicalStatIsProvided_physicalStatShouldNotBeSuperiorAt50(int physicalStat) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.createNewStats(
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
                        fightStat));
        assertEquals("Maximum of Physical Stat is 50, Minimum is 10 and should be divisible by 5", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 34, 70})
    void testCreateCharacterStats_whenDexterityStatIsProvided_dexterityStatShouldNotBeSuperiorAt50(int dexterityStat) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.createNewStats(
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
                        fightStat));
        assertEquals("Maximum of Dexterity Stat is 50, Minimum is 10 and should be divisible by 5", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 34, 70})
    void testCreateCharacterStats_whenPsychicStatIsProvided_psychicStatShouldNotBeSuperiorAt50(int psychicStat) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.createNewStats(
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
                        fightStat));
        assertEquals("Maximum of Psychic Stat is 50, Minimum is 10 and should be divisible by 5", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 34, 70})
    void testCreateCharacterStats_whenWillPowerStatIsProvided_willPowerStatShouldNotBeSuperiorAt50(int willPowerStat) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.createNewStats(
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
                        fightStat));
        assertEquals("Maximum of Will Power Stat is 50, Minimum is 10 and should be divisible by 5", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 34, 70})
    void testCreateCharacterStats_whenFightStatIsProvided_fightStatShouldNotBeSuperiorAt50(int fightStat) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.createNewStats(
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
                        fightStat));
        assertEquals("Maximum of Fight Stat is 50, Minimum is 10 and should be divisible by 5", exception.getMessage());
    }

}
