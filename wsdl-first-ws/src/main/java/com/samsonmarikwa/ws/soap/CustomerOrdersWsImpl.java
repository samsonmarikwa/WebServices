package com.samsonmarikwa.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.samsonmarikwa.CreateOrdersRequest;
import com.samsonmarikwa.CreateOrdersResponse;
import com.samsonmarikwa.CustomerOrdersPortType;
import com.samsonmarikwa.GetOrdersRequest;
import com.samsonmarikwa.GetOrdersResponse;
import com.samsonmarikwa.Order;
import com.samsonmarikwa.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
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
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
		
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		List<Order> orders = customerOrders.get(customerId);
		orders.add(order);
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		
		return response;
	}

}
