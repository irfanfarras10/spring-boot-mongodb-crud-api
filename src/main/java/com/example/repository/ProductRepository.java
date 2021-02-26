package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Product;
import com.example.model.ProductCompositeKey;

public interface ProductRepository extends MongoRepository<Product, ProductCompositeKey> {

}
