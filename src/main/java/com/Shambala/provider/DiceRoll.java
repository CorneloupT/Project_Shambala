package com.Shambala.provider;

import com.Shambala.models.DiceRollPort;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class DiceRoll implements DiceRollPort {

    public int roll(int sides) {
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }

}
