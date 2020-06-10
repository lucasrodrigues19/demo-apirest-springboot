package com.lrvendas.springbootex.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lrvendas.springbootex.entites.User;
import com.lrvendas.springbootex.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}") // vai aceitar um id na url
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) { //@RequestBody pra dizer que o objeto vai chegar em um json na hr da request, e depois ser deserealizado para um obj
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();//instancia a uri
		return ResponseEntity.created(uri).body(user);  
	}
	//201, é um codigo especifico do http, que quer dizer que vc criou um novo recurso 
	//created: espera um objeto do tipo URI, no padrao http é  quando reorna o 201 esperado que a resposta contenha um cabecalho chamado "location" contendo o endereco que vc inseriu
	//path: vai receber um padrao para montar minha url, no caso o recurso que eu inserir vai ter: ex: users/id que eu inserir
	
}
