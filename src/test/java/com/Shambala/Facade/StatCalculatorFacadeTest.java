package com.Shambala.Facade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatCalculatorFacadeTest {

    @Test
    void testGetRandomValueOfDice100() {
        int randomValue = StatCalculatorFacade.getValueOfDice100(1, 100);
        assertTrue(randomValue >= 1 && randomValue <= 100, "la valeur du D100 est entre 1 et 100");
    }

    @Test
    void testAddPrincipalAndSubStatValue() {
        int result = StatCalculatorFacade.getValueOfDice100(principalStat, subStat);
    }
}
