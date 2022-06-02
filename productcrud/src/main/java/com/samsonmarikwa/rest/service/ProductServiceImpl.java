package com.samsonmarikwa.rest.service;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.samsonmarikwa.rest.entities.Product;
import com.samsonmarikwa.rest.repos.ProductRepository;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getProduct() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		return repository.findById(id).get();
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
	public Status deleteProduct(int id) {
		Status status;
		Product product = repository.findById(id).get();
		if (product != null) {
			repository.delete(product);
		}
		
		if ((product != null) && (repository.findById(id).get() == null)) {
			status = Response.Status.NO_CONTENT;
		} else {
			status = Response.Status.NOT_FOUND;
			
		}
		return status;
	}

}
