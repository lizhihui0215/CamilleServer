package com.camille.controller;

import com.camille.model.TAnimal;
import com.camille.model.TUser;
import com.camille.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by lizhihui on 08/02/2017.
 *
 */

@Service
public interface TUserService extends CrudRepository<TUser, Long> {
    TUser findFirstByUsernameAndPassword(String username, String password);

    TUser findFirstByUsername(String username);
}

