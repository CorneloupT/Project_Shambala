package com.Shambala.Facade;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import com.Shambala.models.builder.CharacterSubStatsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StatCalculatorFacadeTest {

    private StatCalculatorFacade calculatorFacade;
    private CharacterPrincipalStatBuilder principalStatBuilder;
    private CharacterSubStatsBuilder subStatsBuilder;

    @BeforeEach
    void setUp() {
        calculatorFacade = new StatCalculatorFacade();

        principalStatBuilder = mock(CharacterPrincipalStatBuilder.class);
        when(principalStatBuilder.getValue()).thenReturn(30);

        subStatsBuilder = mock(CharacterSubStatsBuilder.class);
        when(subStatsBuilder.getSubStatValue()).thenReturn(10);

    }

    @Test
    void testGetRandomValueOfDice100() {
        int randomValue = StatCalculatorFacade.getValueOfDice100();
        assertTrue(randomValue >= 1 && randomValue <= 100, "la valeur du D100 est entre 1 et 100");
    }

    @Test
    void testAddPrincipalAndSubStatValue() {
        int result = StatCalculatorFacade.addStatsValue(principalStatBuilder, subStatsBuilder);
        assertEquals(40, result, "Addition entre les deux statistiques");
    }

    @Test
    void testThrowingDiceResultIsFail() {
        String result = String.valueOf(calculatorFacade.resultD100IsFail(principalStatBuilder, subStatsBuilder));
        assertEquals("Success! addStatValue is greater than the dice roll.", result);
    }
}
