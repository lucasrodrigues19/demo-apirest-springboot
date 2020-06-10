package com.lrvendas.springbootex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lrvendas.springbootex.entites.User;
import com.lrvendas.springbootex.repositories.UserRepository;
import com.lrvendas.springbootex.services.exceptions.DatabaseException;
import com.lrvendas.springbootex.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); //caso nao tenha nemhum objeto, lança uma exessao
	}
	
	public User insert (User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //vai me da um objeto monitorado
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setFone(obj.getFone());
		
	}
}
