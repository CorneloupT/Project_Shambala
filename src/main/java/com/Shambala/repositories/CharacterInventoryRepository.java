package com.Shambala.repositories;

import com.Shambala.models.CharacterInventory;

public interface CharacterInventoryRepository {
    void saveNewInventory(CharacterInventory characterInventory);
}
