package com.gabrielrosenbach.whorkshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.whorkshopmongo.domain.User;
import com.gabrielrosenbach.whorkshopmongo.dto.UserDTO;
import com.gabrielrosenbach.whorkshopmongo.exception.ObjectNotFoundException;
import com.gabrielrosenbach.whorkshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user.get();
	}
	
	public User insert(User user) {
		
		return userRepository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
