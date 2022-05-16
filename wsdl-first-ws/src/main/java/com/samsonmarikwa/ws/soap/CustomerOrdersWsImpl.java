package com.samsonmarikwa.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.samsonmarikwa.CreateOrdersRequest;
import com.samsonmarikwa.CreateOrdersResponse;
import com.samsonmarikwa.CustomerOrdersPortType;
import com.samsonmarikwa.GetOrdersRequest;
import com.samsonmarikwa.GetOrdersResponse;
import com.samsonmarikwa.Order;
import com.samsonmarikwa.Product;

public class CustomerOrdersWsImpl implements CustomerOrdersPortType {
	
	// Create in-memory database 
	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentId;
	
	public CustomerOrdersWsImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		Product product = new Product();
		product.setId("1");
		product.setDescription("iPhone");
		product.setQuantity(BigInteger.valueOf(3));
		
		order.getProduct().add(product);
		orders.add(order);
		
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}
	

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
