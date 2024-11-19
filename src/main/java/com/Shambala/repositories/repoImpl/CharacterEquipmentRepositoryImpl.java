package com.Shambala.repositories.repoImpl;

import com.Shambala.models.CharacterEquipment;
import com.Shambala.repositories.CharacterEquipmentRepository;
import com.Shambala.repositories.Entity.CharacterEquipmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CharacterEquipmentRepositoryImpl implements CharacterEquipmentRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void saveNewEquipment(CharacterEquipment equipment) {
        CharacterEquipmentEntity entity = new CharacterEquipmentEntity();
        equipment.exportEquipment(entity);
        entityManager.persist(entity);
    }
}
