package com.camille.controller;

import com.camille.model.TAnimal;
import org.springframework.data.repository.CrudRepository;

public interface TAnimalServices extends CrudRepository<TAnimal, Long> {
}
