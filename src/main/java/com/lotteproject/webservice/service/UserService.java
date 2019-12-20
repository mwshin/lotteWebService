package com.lotteproject.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotteproject.webservice.domain.User;
import com.lotteproject.webservice.domain.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean createUser(User user){
		try{
			userRepository.save(user);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public Optional<User> getUser(Long id){
		return userRepository.findById(id);
	}
	
	public User updateUser(Long id, User user){
		final Optional<User> fetchedUser = userRepository.findById(id);
		if(fetchedUser.isPresent()){
			user.setId(id);
			return userRepository.save(user);
		}
		else{
			return null;
		}
	}
	
	public User patchUser(Long id, User user){
		final Optional<User> fetchedUser = userRepository.findById(id);
		if(fetchedUser.isPresent()){
			if(user.getName() != null){
				fetchedUser.get().setName(user.getName());
			}
			if(user.getHobby() != null){
				fetchedUser.get().setHobby(user.getHobby());
			}
			return userRepository.save(fetchedUser.get());
		}
		else{
			return null;
		}
	}
	
	public boolean deleteUser(Long id){
		final Optional<User> fetchedUser = userRepository.findById(id);
		if(fetchedUser.isPresent()){
			userRepository.deleteById(id);
			return true;
		}
		else{
			return false;
		}
	}
}
