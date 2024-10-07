package com.Shambala.Service;

import com.Shambala.Enum.Race;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterService {
    public static boolean characterHasAValidName(String name) {
        if(name.isEmpty() || name == null)  {
            return false;
        }
        return name.matches("[A-Za-z ]+");
    }

    public static Set<String> getAllRaces() {
        return Arrays.stream(Race.values())
                     .map(Enum::name)
                     .collect(Collectors.toSet());
    }
}
