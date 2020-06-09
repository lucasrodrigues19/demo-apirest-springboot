package com.lrvendas.springbootex.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrvendas.springbootex.entites.User;
import com.lrvendas.springbootex.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping 
	public ResponseEntity<List<User>>findAll(){
			List<User> list = service.findAll();
		    return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}") //vai aceitar um id na url
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
