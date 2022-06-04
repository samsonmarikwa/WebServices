package com.samsonmarikwa.rest.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsonmarikwa.rest.entities.Product;
import com.samsonmarikwa.rest.repos.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			throw new NotFoundException("Product Not Found!");
		}
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException("Product Not Found!");
		}
	}

}
