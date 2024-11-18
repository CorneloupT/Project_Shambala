package com.Shambala.repositories.Entity;

import com.Shambala.models.Character;
import com.Shambala.models.User;
import com.Shambala.models.builder.UserBuilder;
import com.Shambala.models.export.UserExport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class UserEntity implements UserExport, UserBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private String nickName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Character> characterList;

    public User toUserModel() {
        return User.fromBuilder(this);
    }

    @Override
    public void setListCharacter(List<Character> characterList) {

    }

}
