package com.spring.practice.demo;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class productservice
{
    private static HashMap<String, Product> productRepo = new HashMap<>();

    static
    {
        Product honey = new Product();

        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);

        Product pista = new Product();
        pista.setId("3");
        pista.setName("pista");
        productRepo.put(pista.getId(), pista);

        Product test = new Product();
        test.setId("4");
        test.setName("test");
        productRepo.put(test.getId(), test);

        Product itest = new Product();
        itest.setId("5");
        itest.setName("itest");
        productRepo.put(itest.getId(), itest);




    }

    @RequestMapping(value = "/products" , method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct()
    {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product)
    {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }





}