package com.Shambala.models;

import com.Shambala.Enum.Race;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Race race;
    private String playerClass;
    private int globalLevel;
    private int experience;
    private int classLevel;
    private int classExperience;
    private String background;

    public Character(String name, Race race, String playerClass, int globalLevel, int experience, int classLevel, int classExperience, String background) {
        this.name = name;
        this.race = race;
        this.globalLevel = globalLevel;
        this.playerClass = playerClass;
        this.experience = experience;
        this.classLevel = classLevel;
        this.classExperience = classExperience;
        this.background = background;
    }


}