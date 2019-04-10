package com.myretailstore.api.onlineorders.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myretailstore.api.onlineorders.dao.Order;
import com.myretailstore.api.onlineorders.exceptions.OrderNotFoundException;
import com.myretailstore.api.onlineorders.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	OrdersService orderService;

	@GetMapping(path = "/orders")
	public List<Order> retrieveAllOrders() {
		return orderService.retrieveAllOrders();
	}

	@GetMapping(path = "/orders/{orderid}")
	public Order retrieveOrder(@PathVariable int orderid) {
		Order order = orderService.retrieveOrder(orderid);
		if (order == null) {
			throw new OrderNotFoundException("Order Id : " + orderid);
		}
		return order;
	}

	@PostMapping(path = "/orders")
	public ResponseEntity<Object> createOrder(@RequestBody Order order) {
		Order createdOrder = orderService.saveOrder(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderid}")
				.buildAndExpand(createdOrder.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/orders/{orderid}")
	public void deleteOrder(@PathVariable int orderid) {
		Order createdOrder = orderService.deleteOrder(orderid);

		if (createdOrder == null) {
			throw new OrderNotFoundException("Order Id : " + orderid);
		}

	}
	
	@PutMapping(path = "/orders/{orderid}")
	public void updateOrder(@PathVariable int orderid, @RequestBody Order order) {
		Order updatedOrder = orderService.updateOrder(orderid, order);

		if (updatedOrder == null) {
			throw new OrderNotFoundException("Order Id : " + orderid);
		}

	}

}