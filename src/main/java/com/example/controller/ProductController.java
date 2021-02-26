package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.ProductCompositeKey;
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
	
	@GetMapping("product")
	public Optional<Product> get(@RequestParam String storeId, @RequestParam String skuSeller){
		return this.productRepository.findById(new ProductCompositeKey(storeId, skuSeller));
	}
	
	@PostMapping("product")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody Product product) {
		product.set_id(product.get_id());
		product.setCreatedDate(LocalDateTime.now());
		product.setUpdateDate(LocalDateTime.now());
		this.productRepository.save(product);
		return "Product Saved";
	}	
	
	@PutMapping("product")
	public String update(@RequestBody Product product, @RequestParam String storeId, @RequestParam String skuSeller) {
		Optional<Product> updatedProduct = productRepository.findById(new ProductCompositeKey(storeId, skuSeller));
		updatedProduct.ifPresent(p -> p.setUpdateDate(LocalDateTime.now()));
		updatedProduct.ifPresent(p -> p.setStatus(product.getStatus()));
		updatedProduct.ifPresent(p -> p.setStockAvailable(product.getStockAvailable()));
		updatedProduct.ifPresent(p -> productRepository.save(p));
		return "Product Updated";
	}
	
	@DeleteMapping("product")
	public String delete(@RequestParam String storeId, @RequestParam String skuSeller) {
		productRepository.deleteById(new ProductCompositeKey(storeId, skuSeller));
		return "Product Deleted";
	}
	
}
