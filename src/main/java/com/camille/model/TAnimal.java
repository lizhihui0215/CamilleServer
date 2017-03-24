package com.camille.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_animal")
public class TAnimal{
    @Id
    @GeneratedValue
    private Long id;

    public String name;

    public String age;

    public TAnimal() {
    }
}
