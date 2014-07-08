package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.User;
import com.web.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

	public User get(Long id){
		return repo.findById(id);
	}
	
	@Transactional
	public User save(User user){
		return repo.save(user);
	}
}
