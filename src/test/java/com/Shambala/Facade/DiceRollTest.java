package com.Shambala.Facade;

import com.Shambala.provider.DiceRoll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceRollTest {

    private DiceRoll diceRoll;

    @BeforeEach
    void setUp() {
        diceRoll = new DiceRoll();
    }

    @Test
    void testGetRandomValueOFDice4() {
        int randomD4Value = new DamageCalculatorFacade(diceRoll).rollDamageDice(4);
        assertTrue(randomD4Value >= 1 && randomD4Value <= 4, "la valeur du D4 est comprise entre 1 et 4");
    }

    @Test
    void testGetRandomValueOfDice6() {
        int randomD6Value = new DamageCalculatorFacade(diceRoll).rollDamageDice(6);
        assertTrue(randomD6Value >= 1 && randomD6Value <= 6, "la valeur du D6 est comprise entre 1 et 6");
    }

    @Test
    void testGetRandomValueOfDice8() {
        int randomD8Value = new DamageCalculatorFacade(diceRoll).rollDamageDice(8);
        assertTrue(randomD8Value >= 1 && randomD8Value <= 8, "la valeur du D8 est comprise entre 1 et 8");
    }

    @Test
    void testGetRandomValueOfDice10() {
        int randomD10Value = new DamageCalculatorFacade(diceRoll).rollDamageDice(10);
        assertTrue(randomD10Value >= 1 && randomD10Value <= 10, "la valeur du D10 est comprise entre 1 et 10");
    }

    @Test
    void testGetRandomValueOfDice12() {
        int randomD12Value = new DamageCalculatorFacade(diceRoll).rollDamageDice(12);
        assertTrue(randomD12Value >= 1 && randomD12Value <= 12, "la valeur du D12 est comprise entre 1 et 12");
    }
}
