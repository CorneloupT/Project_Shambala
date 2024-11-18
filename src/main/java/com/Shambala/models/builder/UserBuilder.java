package com.Shambala.models.builder;

import com.Shambala.models.Character;

import java.util.List;

public interface UserBuilder {

    long getId();

    String getLastName();

    String getFirstName();

    String getEmail();

    String getNickName();

    String getPassword();

    List<Character> getCharacterList();

}
