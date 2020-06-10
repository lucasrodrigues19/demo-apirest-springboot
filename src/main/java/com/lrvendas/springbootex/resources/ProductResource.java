package com.lrvendas.springbootex.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrvendas.springbootex.entites.Product;
import com.lrvendas.springbootex.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping 
	public ResponseEntity<List<Product>>findAll(){
			List<Product> list = service.findAll();
		    return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}") //vai aceitar um id na url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
