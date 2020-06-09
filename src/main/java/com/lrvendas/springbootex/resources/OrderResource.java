package com.lrvendas.springbootex.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrvendas.springbootex.entites.Order;
import com.lrvendas.springbootex.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping 
	public ResponseEntity<List<Order>>findAll(){
			List<Order> list = service.findAll();
		    return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}") //vai aceitar um id na url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
