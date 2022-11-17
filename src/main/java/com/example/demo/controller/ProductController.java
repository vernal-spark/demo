package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.KafkaService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    KafkaService kafkaProducer;
    @GetMapping("")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products=service.getAllProducts();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProducctById(@PathVariable int id){
        Product product =service.getProductById(id);
        kafkaProducer.send(product);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        service.saveProduct(product);
        return new ResponseEntity<>("Product Added",HttpStatus.OK);
    }
    @DeleteMapping("/{id")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return new ResponseEntity<>("product deleted",HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        service.updateProduct(product);
        return new ResponseEntity<>("product updated",HttpStatus.OK);
    }
}
