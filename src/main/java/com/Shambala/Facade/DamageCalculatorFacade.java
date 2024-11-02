package com.Shambala.Facade;

public class DamageCalculatorFacade {

    public int rollDamageDice(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public int getValueOfDice4() {
        return rollDamageDice(4);
    }

    public int getValueOfDice6() {
        return rollDamageDice(6);
    }

    public int getValueOfDice8() {
        return rollDamageDice(8);
    }

    public int getValueOfDice10() {
        return rollDamageDice(10);
    }

    public int getValueOfDice12() {
        return rollDamageDice(12);
    }
}
