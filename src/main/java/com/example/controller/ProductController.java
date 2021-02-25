package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("products")
	public List<Product> all(){
		return this.productRepository.findAll();
	}
	
	@GetMapping("product/{id}")
	public Optional<Product> get(@PathVariable String id){
		return this.productRepository.findById(id);
	}
	
	@PostMapping("product")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return this.productRepository.save(product);
	}	
	
	@PutMapping("product/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable String id) {
		product.setId(id);
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("product/{id}")
	public void delete(@PathVariable String id) {
		productRepository.deleteById(id);
	}
	
}
