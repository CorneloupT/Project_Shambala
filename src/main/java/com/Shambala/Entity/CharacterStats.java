package com.Shambala.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int life;
    private int ethenano;
    private int luckyPoint;
    private int protection;
    private int physical;
    private int agility;
    private int psychic;
    private int will;
    private int fight;

    @OneToOne
    @JoinColumn(name = "character_id")
    private Character character;
}
