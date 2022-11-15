package fr.crudapi.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import fr.crudapi.demo.model.User;
import fr.crudapi.demo.repository.UserRepository;
import fr.crudapi.demo.request.UserRequest;
import fr.crudapi.demo.response.MessageResponse;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public ResponseEntity<?> creatUser(UserRequest userRequest) {
		
		User user = new User();
		user.setName(userRequest.getName());
		user.setAge(userRequest.getAge());
		userRepository.save(user);
		return new ResponseEntity<>(new MessageResponse ("ça marche merci bg Alex"),HttpStatus.ACCEPTED);
		
	}
	public Object getUser() {
		List<User> user =  userRepository.findAll();

		return user;
	}
	
	public Object getUserId(Long id) {
		Optional<User> user =  userRepository.findById(id);
		return user;
	}
	public ResponseEntity<?> updateUser(@Valid UserRequest userRequest,Long id) {
		User updateUser = userRepository.findById(id).get();
				updateUser.setName(userRequest.getName());
				updateUser.setAge(userRequest.getAge());
				userRepository.save(updateUser);
		return new ResponseEntity<>(new MessageResponse ("this user is Update"),HttpStatus.ACCEPTED);
	}

}
