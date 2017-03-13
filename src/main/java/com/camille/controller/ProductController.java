package com.camille.controller;

import com.camille.domain.ProductServices;
import com.camille.model.Product;
import com.camille.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhihui on 13/03/2017.
 */
@Controller
public class ProductController {

    private ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping("/api/save/products")
    @ResponseBody
    public ResponseObject<String> saveProducts(@RequestBody List<Product> products){
        this.productServices.save(products);
        return new ResponseObject<>(0, "success","success");
    }

    @PostMapping("/api/all/products")
    @ResponseBody
    public ResponseObject<ArrayList<Product>> allProducts(@RequestBody Map<String,String> parameters){
        Iterable<Product> all = this.productServices.findAll();

        ArrayList<Product> products = new ArrayList<>();

        all.forEach(product -> products.add(product));

        return new ResponseObject(0,"success", products);
    }

    @PostMapping("/api/update/products")
    @ResponseBody
    public ResponseObject<String> update(@RequestBody List<Product> products) {

        this.productServices.save(products);

        return new ResponseObject(0,"success","success");
    }


    @PostMapping("/api/delete/products")
    @ResponseBody
    public ResponseObject<String> delete(@RequestBody List<Product> products) {

        this.productServices.delete(products);

        return new ResponseObject(0,"success","success");
    }

}
