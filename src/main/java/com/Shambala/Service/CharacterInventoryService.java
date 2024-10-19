package com.Shambala.Service;

import java.util.List;

public interface CharacterInventoryService {

    void createCharacterInventory(int gold,
                                  String head,
                                  String arm,
                                  String bust,
                                  String leg,
                                  String foot,
                                  String rightHand,
                                  String leftHand,
                                  List<String> bag);
}
