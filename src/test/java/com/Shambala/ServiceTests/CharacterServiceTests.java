package com.Shambala.ServiceTests;

import com.Shambala.Service.CharacterService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterServiceTests {

    @Test
    public void characterName_ShouldNotBeEmpty() {
        String name = "Tom";
        boolean validName = CharacterService.characterHasAValidName(name);

        assertTrue(validName);
    }

    @Test
    public void chracterName_ShouldNotBeNull() {
        String name = "Efrim";
        boolean nameNotNull = CharacterService.characterHasNotANullName(name);

        assertTrue(nameNotNull);
    }
}
