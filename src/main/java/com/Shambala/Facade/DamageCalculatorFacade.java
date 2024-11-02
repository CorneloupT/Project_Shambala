package com.Shambala.Facade;

public class DamageCalculatorFacade {

    public int getValueOfDice6() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getValueOfDice8() {
        return (int) (Math.random() * 8) + 1;
    }

    public int getValueOfDice10() {
        return (int) (Math.random() * 10) + 1;
    }

    public int getValueOfDice12() {
        return (int) (Math.random() * 12) + 1;
    }
}
