package com.camille.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lizhihui on 23/03/2017.
 */
@Entity
@Table(name = "t_user")
public class TUser {
    @Id
    @GeneratedValue
    private Long id;

    public String username;

    public String password;

    @OneToMany(fetch=FetchType.EAGER)
    public Set<TAnimal> dogs;

    public TUser() {
    }

    public String getPassword() {
        return password;
    }
}

