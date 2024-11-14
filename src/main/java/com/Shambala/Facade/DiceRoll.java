package com.Shambala.Facade;

import java.util.concurrent.ThreadLocalRandom;

public class DiceRoll {

    public int roll(int sides) {
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }

}
