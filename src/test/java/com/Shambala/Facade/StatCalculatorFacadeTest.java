package com.Shambala.Facade;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.Shambala.models.CharacterPrincipalStat;
import com.Shambala.models.CharacterSubStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StatCalculatorFacadeTest {

    private StatCalculatorFacade calculatorFacade;
    private CharacterPrincipalStat principalStat;
    private CharacterSubStats subStats;

    @BeforeEach
    void setUp() {
        calculatorFacade = spy(new StatCalculatorFacade());

        principalStat = mock(CharacterPrincipalStat.class);
        when(principalStat.getValue()).thenReturn(30);

        subStats = mock(CharacterSubStats.class);
        when(subStats.getSubStatValue()).thenReturn(10);

    }

    @Test
    void testGetRandomValueOfDice100() {
        int randomValue = calculatorFacade.getValueOfDice100();
        assertTrue(randomValue >= 1 && randomValue <= 100, "la valeur du D100 est entre 1 et 100");
    }

    @Test
    void testAddPrincipalAndSubStatValue() {
        int result = calculatorFacade.addStatsValue(principalStat, subStats);
        assertEquals(40, result, "Addition entre les deux statistiques");
    }

    @Test
    void testThrowingDiceResultIsFail() {
        when(calculatorFacade.getValueOfDice100()).thenReturn(51);

        String result = String.valueOf(calculatorFacade.resultD100AndConsequences(principalStat, subStats));
        assertEquals("Fail! addStatValue is greater than the dice roll.", result);
    }

    @Test
    void testThrowingDiceResultIsSuccess() {
        when(calculatorFacade.getValueOfDice100()).thenReturn(33);

        String result = String.valueOf(calculatorFacade.resultD100AndConsequences(principalStat, subStats));
        assertEquals("Success! addStatValue is lesser than the dice roll.", result);
    }

    @Test
    void testThrowingDiceResultIsCriticalFail() {
        when(calculatorFacade.getValueOfDice100()).thenReturn(99);

        String criticalResult = String.valueOf(calculatorFacade.resultD100AndConsequences(principalStat, subStats));
        assertEquals("Aie ! ça ressemble à un échec critique !", criticalResult);
    }

    @Test
    void testThrowingDiceResultIsCriticalSuccess() {
        when(calculatorFacade.getValueOfDice100()).thenReturn(2);

        String criticalResult = String.valueOf(calculatorFacade.resultD100AndConsequences(principalStat, subStats));
        assertEquals("Critical Success !!", criticalResult);
    }

}
