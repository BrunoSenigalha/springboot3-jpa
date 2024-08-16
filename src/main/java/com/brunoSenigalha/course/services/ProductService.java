package com.brunoSenigalha.course.services;

import com.brunoSenigalha.course.entities.Product;
import com.brunoSenigalha.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        throw new IllegalArgumentException("Invalid product id");
    }
}
