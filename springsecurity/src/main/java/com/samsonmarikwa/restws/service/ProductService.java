package com.samsonmarikwa.restws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.samsonmarikwa.restws.model.Product;

@Path("/productsservice")
public interface ProductService {

	@Path("/products")
	@GET
	List<Product> getProducts();
	
	@Path("/products")
	@POST
	int addProduct(Product product);
	
}
