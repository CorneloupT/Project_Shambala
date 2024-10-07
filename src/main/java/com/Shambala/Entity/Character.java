package com.Shambala.Entity;

import com.Shambala.Enum.Race;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Ainsi donc, tu n'as pas de nom ?")
    private String name;

    private String playerClass;
    private String background;

    @NotEmpty(message = "Il faut choisir ton espèce, même si tu es un blob")
    private Race race;

    private String classExperience;
    private String globalExperience;

    @OneToOne
    private CharacterStats characterStats;


}
