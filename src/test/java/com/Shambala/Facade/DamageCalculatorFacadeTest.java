package com.Shambala.Facade;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DamageCalculatorFacadeTest {

    private DamageCalculatorFacade damageCalculatorFacade;

    @BeforeEach
    void setUp() {
        damageCalculatorFacade = new DamageCalculatorFacade();
    }

    @Test
    void testGetRandomValueOfDice6() {
        int randomD6Value = damageCalculatorFacade.getValueOfDice6();
        assertTrue(randomD6Value >= 1 && randomD6Value <= 6, "la valeur du D6 est comprise entre 1 et 6");
    }

    @Test
    void testGetRandomValueOfDice8() {
        int randomD8Value = damageCalculatorFacade.getValueOfDice8();
        assertTrue(randomD8Value >= 1 && randomD8Value <= 8, "la valeur du D8 est comprise entre 1 et 8");
    }

    @Test
    void testGetRandomValueOfDice10() {
        int randomD10Value = damageCalculatorFacade.getValueOfDice10();
        assertTrue(randomD10Value >= 1 && randomD10Value <= 10, "la valeur du D10 est comprise entre 1 et 10");
    }

    @Test
    void testGetRandomValueOfDice12() {
        int randomD12Value = damageCalculatorFacade.getValueOfDice12();
        assertTrue(randomD12Value >= 1 && randomD12Value <= 12, "la valeur du D12 est comprise entre 1 et 12");
    }


}
