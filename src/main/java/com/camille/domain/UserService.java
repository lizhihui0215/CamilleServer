package com.camille.domain;

import com.camille.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by lizhihui on 09/02/2017.
 *
 */
@Service
public interface UserService extends CrudRepository<User, Long> {
    User findFirstByUsername(String username);
}

