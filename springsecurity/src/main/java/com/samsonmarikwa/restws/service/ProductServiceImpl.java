package com.samsonmarikwa.restws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samsonmarikwa.restws.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getProducts() {
		return null;
	}

	@Override
	public int addProduct(Product product) {
		return 0;
	}

}
