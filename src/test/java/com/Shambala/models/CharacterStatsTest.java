package com.Shambala.models;

import com.Shambala.models.builder.CharacterStatsBuilder;
import com.Shambala.models.export.CharacterStatsExport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharacterStatsTest {

    private int lifePoints;
    private int lifePointsMax;
    private int ENPoints;
    private int ENPointsMax;
    private int luckyPoints;
    private int protection;

    @BeforeEach
    void Setup() {
        lifePoints = 12;
        lifePointsMax = 14;
        ENPoints = 3;
        ENPointsMax = 5;
        luckyPoints = 5;
        protection = 2;
    }

    private record InnerBuilder(int getLifePoint,
                                int getLifePointMax,
                                int getENPoints,
                                int getENPointsMax,
                                int getLuckyPoint,
                                int getProtection)
            implements CharacterStatsBuilder {
    }

    private CharacterStatsBuilder createCharacterStats() {
        return new InnerBuilder(lifePoints, lifePointsMax,ENPoints, ENPointsMax, luckyPoints, protection);
    }

    @Test
    void testCreateCharacterStats_whenStatsAreProvided_returnAllStatsFromBuilder() {
        //Act
        CharacterStats characterStats = CharacterStats.fromStatBuilder(new InnerBuilder(
                10, 12,5,5,5,2
        ));
        //Assert
        assertNotNull(characterStats);
    }

    @Test
    void testCreateCharacterStats_whenLifePointsAreProvided_returnLifePoints() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(lifePoints, characterStats.getLifePoints());
    }

    @Test
    void testCreateCharacterStats_whenMaxLifePointsAreProvided_returnMaxLifePoints() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(lifePointsMax, characterStats.getLifePointsMax());
    }

    @Test
    void testCreateCharacterStats_whenENPointsAreProvided_returnENPoints() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(ENPoints, characterStats.getENPoints());
    }

    @Test
    void testCreateCharacterStats_whenMaxENPointsAreProvided_returnMaxENPoints() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(lifePointsMax, characterStats.getLifePointsMax());
    }

    @Test
    void testCreateCharacterStats_whenLuckyPointAreProvided_returnMaxLuckyPoint() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(luckyPoints, characterStats.getLuckyPoints());
    }

    @Test
    void testCreateCharacterStats_whenProtectionIsProvided_returnProtection() {
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        assertEquals(protection, characterStats.getProtection());
    }

    @Test
    void testCreateCharacterStats_whenLifePointsAndMaxLifePointsAreProvided_lifePointsMaxIsMaximum() {
        lifePoints = 15;
        lifePointsMax = 14;

        IllegalArgumentException lifePointException = assertThrows(IllegalArgumentException.class,
                () -> CharacterStats.fromStatBuilder(createCharacterStats()));

        assertEquals("life points and EN points are always less than or equal to their maximum", lifePointException.getMessage());
    }

    @Test
    void testCreateCharacterStats_whenENPointsAndENPointsMaxAreProvided_ENPointsMaxIsMaximum() {
        ENPoints = 7;
        ENPointsMax = 6;

        IllegalArgumentException ENPointsException = assertThrows(IllegalArgumentException.class,
                () -> CharacterStats.fromStatBuilder(createCharacterStats()));

        assertEquals("life points and EN points are always less than or equal to their maximum", ENPointsException.getMessage());
    }

    @Test
    void shouldExportStatValue() {
        CharacterStatsExport statsExport = mock(CharacterStatsExport.class);
        CharacterStats characterStats = CharacterStats.fromStatBuilder(createCharacterStats());
        characterStats.exportTo(statsExport);

        verify(statsExport).setLifePoints(eq(12));
        verify(statsExport).setLifePointsMax(eq(14));
        verify(statsExport).setENPoints(eq(3));
        verify(statsExport).setENPointsMax(eq(5));
        verify(statsExport).setLuckyPoints(eq(5));
        verify(statsExport).setProtection(eq(2));
    }
}