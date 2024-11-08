package com.Shambala.Facade;

import java.util.Random;

public class DiceRoll implements Dice{

    private final Random random = new Random();

    @Override
    public int roll(int sides) {
        return random.nextInt(sides) + 1;
    }

}
