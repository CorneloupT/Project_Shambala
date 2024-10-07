package com.Shambala.Service;

public class CharacterService {
    public static boolean characterHasAValidName(String name) {
        if(name.isEmpty() || name == null)  {
            return false;
        }
        return name.matches("[A-Za-z ]+");
    }

    public static boolean characterHasNotANullName(String name) {
        if(name != null) {
            return true;
        }
        return false;
    }
}
