package com.Shambala.Service;

public class CharacterService {
    public static boolean characterHasAValidName(String name) {
        if(!name.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean characterHasNotANullName(String name) {
        if(name != null) {
            return true;
        }
        return false;
    }
}
