package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).get();
    }

    public void saveProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public void updateProduct(Product product) {
        repo.deleteById(product.getPid());
        repo.save(product);
    }
}
