package com.myretailstore.api.onlineorders.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.myretailstore.api.onlineorders.dao.Address;
import com.myretailstore.api.onlineorders.dao.Customer;
import com.myretailstore.api.onlineorders.dao.Order;
import com.myretailstore.api.onlineorders.dao.Price;
import com.myretailstore.api.onlineorders.dao.Product;

/**
 * This is main service or model as in MVC. This class holds actual business processing logic i.e.
 * creating a new order, updating new order, retrieving all orders or delete an order.
 * @author fahadbinrahat
 *
 */

@Component
public class OrdersService {

	private static List<Order> orders = new ArrayList<Order>();

	private static int orderCount = 2;
	
	/*
	 * Using a static list (in-memory list of orders which refreshes every time server restarts)
	 * In actual implementation this will be replaced with actual Model having interaction with 
	 * back-end via wrapper APIs or stored procedure etc.
	 * 
	 * Also there are no constraints/checks on ids and duplications etc.
	 * */

	static {

		Address address = new Address();
		address.setCountry("Australia");
		address.setPostCode("2000");
		address.setState("NSW");
		address.setStreetName("Harbour");
		address.setStreetNumber("1-11");
		address.setStreetType("Street");
		address.setSuburb("Sydney");

		Customer customer1 = new Customer();
		customer1.setAddress(address);
		customer1.setId(1);
		customer1.setName("John");
		customer1.setPhone("040000000");

		Customer customer2 = new Customer();
		customer2.setAddress(address);
		customer2.setId(2);
		customer2.setName("Peter");
		customer2.setPhone("050000000");

		Product product1 = new Product();
		product1.setCategory("Electronics");
		product1.setDescription("IPhone");
		product1.setName("IPhone");
		product1.setPrice(new Price(600.00, Price.priceCurrency.AUD));

		Product product2 = new Product();
		product2.setCategory("Electronics");
		product2.setDescription("Galaxy");
		product2.setName("Galaxy");
		product2.setPrice(new Price(400.00, Price.priceCurrency.AUD));

		Order order1 = new Order(1, "My Iphone Order", Order.orderStatus.PROCESSED, new Date(), customer1, product1);
		Order order2 = new Order(2, "My Galaxy Order", Order.orderStatus.PROCESSED, new Date(), customer2, product2);
		orders.add(order1);
		orders.add(order2);

	}

	public List<Order> retrieveAllOrders() {

		return orders;

	}

	public Order saveOrder(Order order) {

		if (order.getId() == null) {
			order.setId(++orderCount);
		}
		orders.add(order);
		return order;

	}
	
	public Order updateOrder(Integer id, Order updatedOrder) {

		Iterator<Order> iterator = orders.iterator();
		while(iterator.hasNext()) {
			Order order = iterator.next();
			if(order.getId()==id) {
				BeanUtils.copyProperties(updatedOrder,order);
				return order;
			}
			
		}
		return null;

	}

	public Order retrieveOrder(Integer id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}
	
	public Order deleteOrder(Integer id) {
		
		Iterator<Order> iterator = orders.iterator();
		while(iterator.hasNext()) {
			Order order = iterator.next();
			if(order.getId()==id) {
				iterator.remove();
				return order;
			}
			
		}
		return null;
	}

}
