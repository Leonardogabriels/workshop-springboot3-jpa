package com.leonardo.webServices.service;

import java.util.List;
import java.util.Optional;

import com.leonardo.webServices.service.exceptions.DatabaseException;
import com.leonardo.webServices.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.leonardo.webServices.entities.User;
import com.leonardo.webServices.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {

		return repository.save(user);
	}

	public void delete(Long id){
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e ){
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj){
		User newUser = repository.getReferenceById(id);
		updateData(newUser,obj);
		return repository.save(newUser);
	}

	private void updateData(User dataUp, User obj) {
		dataUp.setName(obj.getName());
		dataUp.setEmail(obj.getEmail());
		dataUp.setPhone(obj.getPhone());

	}
}