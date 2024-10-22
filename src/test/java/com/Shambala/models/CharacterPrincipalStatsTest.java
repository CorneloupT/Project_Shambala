package com.Shambala.models;

import com.Shambala.models.builder.CharacterPrincipalStatBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPrincipalStatsTest {

    // Je ne sais pas dans quel ordre m'y prendre avec les builders pour les tests. Donc je vais faire comme suit :
    // 1) implémentation du test
    // 2) création de l'interface CharacterPrincipalStatBuilder
    // 3) création de la classe CharacterPrincipalStat
    // 4) Initialisation du paramètre physical et du setUp()
    // 5) Construction du testBuilder et de createTestPrincipalStat()
    // 6) Lancement du test

    private int physical;

    @BeforeEach
    void setUp() {
        physical = 30;
    }

    private record TestBuilder(int getPhysical) implements CharacterPrincipalStatBuilder {

    }

    private CharacterPrincipalStatBuilder createTestPrincipalStat() {
        return new TestBuilder(physical);
    }

    @Test
    void should_create_character_principal_stat_from_builder() {
        CharacterPrincipalStat characterPrincipalStat = CharacterPrincipalStat.fromBuilder(new TestBuilder(30));
        assertNotNull(characterPrincipalStat);
    }
}
