package com.Shambala.ServiceStatsTests;

import com.Shambala.Service.CharacterStatService;
import com.Shambala.Service.ServiceImpl.CharacterStatServiceImpl;
import com.Shambala.models.CharacterStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerifyPrincipalStatsTest {

    private CharacterStatService characterStatService;

    @BeforeEach
    void setup() {
        characterStatService = new CharacterStatServiceImpl();
    }

    static Stream<Arguments> statsProvider() {
        return Stream.of(
                Arguments.of(10, 34, 40, 50, 20),
                Arguments.of(5, 20, 30, 40, 50),
                Arguments.of(10, 20, 30, 40, 70)
        );
    }

    @ParameterizedTest
    @MethodSource("statsProvider")
    void testVerifyPrincipalCharacterStats_WhenPrincipalsStatsAreProvided_ShouldBeSupTo50_InfTo10_DivisibleBy5(int physicalStat, int dexterityStat, int psychicStat, int willPowerStat, int fightStat) {
        CharacterStats principalStats = new CharacterStats();
        principalStats.setPhysicalStat(physicalStat);
        principalStats.setDexterityStat(dexterityStat);
        principalStats.setPsychicStat(psychicStat);
        principalStats.setWillPowerStat(willPowerStat);
        principalStats.setFightStat(fightStat);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                characterStatService.verifyPrincipalCharacterStats(principalStats));
        assertEquals("Principal Stat should not be superior to 50, inferior to 10 and divisible by 5", exception.getMessage());
    }
}
