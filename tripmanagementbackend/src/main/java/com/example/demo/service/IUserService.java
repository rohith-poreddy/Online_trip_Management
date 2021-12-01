package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@Service
@Transactional
public class IUserService {
	
	@Autowired
	IUserRepository userRepo;
	
	public User addUser(User user)
	{
		userRepo.save(user);
		return user;
	}
	
	public User viewUser(long id) throws ResourceNotFoundException {
		return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Id : "+id+" not found!!"));
		
	}

}
