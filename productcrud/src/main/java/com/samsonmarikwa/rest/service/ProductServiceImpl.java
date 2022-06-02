package com.samsonmarikwa.rest.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.samsonmarikwa.rest.entities.Product;
import com.samsonmarikwa.rest.repos.ProductRepository;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			throw new NotFoundException("Product Not Found!");
		}
	}

	@Override
	public Response createProduct(Product product) {
		Product savedProduct = repository.save(product);
		return Response.ok(savedProduct).build();
	}

	@Override
	public Response updateProduct(Product product) {
		Product savedProduct = repository.save(product);
		return Response.ok(savedProduct).build();
	}

	@Override
	public void deleteProduct(int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException("Product Not Found!");
		}
	}

}
