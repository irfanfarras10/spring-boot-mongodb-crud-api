package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public String create(@RequestBody Product product) {
		product.setCreatedDate(LocalDateTime.now());
		product.setUpdateDate(LocalDateTime.now());
		this.productRepository.save(product);
		return "Product Saved";
	}	
	
	@PutMapping("product/{id}")
	public String update(@RequestBody Product product, @PathVariable String id) {
		Optional<Product> updatedProduct = productRepository.findById(id);
		updatedProduct.ifPresent(p -> p.setUpdateDate(LocalDateTime.now()));
		updatedProduct.ifPresent(p -> p.setSkuSeller(product.getSkuSeller()));
		updatedProduct.ifPresent(p -> p.setStatus(product.getStatus()));
		updatedProduct.ifPresent(p -> p.setStockAvailable(product.getStockAvailable()));
		updatedProduct.ifPresent(p -> productRepository.save(p));
		return "Product With ID " + id + " " + "Updated";
	}
	
	@DeleteMapping("product/{id}")
	public String delete(@PathVariable String id) {
		productRepository.deleteById(id);
		return "Product With ID " + id + " " + "Deleted";
	}
	
}
