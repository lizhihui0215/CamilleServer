package com.camille.domain;

import com.camille.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by lizhihui on 13/03/2017.
 */
@Service
public interface ProductServices extends CrudRepository<Product, String> {

}
