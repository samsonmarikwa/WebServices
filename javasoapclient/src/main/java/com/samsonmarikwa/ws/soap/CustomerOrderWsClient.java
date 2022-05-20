package com.samsonmarikwa.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.samsonmarikwa.CreateOrdersRequest;
import com.samsonmarikwa.CreateOrdersResponse;
import com.samsonmarikwa.CustomerOrdersPortType;
import com.samsonmarikwa.GetOrdersRequest;
import com.samsonmarikwa.GetOrdersResponse;
import com.samsonmarikwa.Order;
import com.samsonmarikwa.Product;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Number of orders for the customer are: " + orders.size());
		System.out.println("Order Details");
		for(Order order : orders) {
			System.out.println("Order Id: " + order.getId());
			System.out.print("Order Size: " + order.getProduct().size());
		}
		
		System.out.println("======================================");
		
		CreateOrdersRequest ordersRequest = new CreateOrdersRequest();
		ordersRequest.setCustomerId(BigInteger.valueOf(1));
		Order order = new Order();
		order.setId(BigInteger.valueOf(2));
		Product product = new Product();
		product.setId("2");
		product.setDescription("Dell laptop");
		product.setQuantity(BigInteger.valueOf(2));
		order.getProduct().add(product);
		ordersRequest.setOrder(order);
		
		CreateOrdersResponse createOrdersResponse = customerOrdersWsImplPort.createOrders(ordersRequest);
		boolean result = createOrdersResponse.isResult();
		System.out.println("Orders created: " + result);
		
		orders = response.getOrder();
		System.out.println("Number of orders for the customer are: " + orders.size());
		System.out.println("Order Details");
		for(Order order1 : orders) {
			System.out.println("Order Id: " + order1.getId());
			System.out.print("Order Size: " + order1.getProduct().size());
		}
		

	}

}
