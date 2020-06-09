package com.lrvendas.springbootex.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrvendas.springbootex.entites.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping 
	public ResponseEntity<User>findAll(){
		return ResponseEntity.ok().body(new User(1L, "Maria", "maria@gmail.com", "1234645", "1234"));
		
	}
}
