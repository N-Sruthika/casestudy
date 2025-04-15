package com.example.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.exception.InvalidUsernameException;
import com.example.casestudy.model.User;
import com.example.casestudy.repository.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public User signUp(User user) throws InvalidUsernameException {
		//check if Username is unique 
		User user1 =  (User) authRepository.findByUsername(user.getUsername());
		if(user1 != null) { 
			//if user exists it will be not null. if its a new username then it will be null 
			throw new InvalidUsernameException("Username already exists");
		}
		/*Give role USER_DEFAULT if not provided */
		if(user.getRole() == null)
			user.setRole("USER_DEFAULT");
		
		//encode the password 
		String encodedPass = bcrypt.encode(user.getPassword());
		
		//attach encoded pass to user 
		user.setPassword(encodedPass);
		
		return authRepository.save(user);
	}

	public User getUserById(int uid) throws InvalidIDException {
        Optional<User> optional = authRepository.findById(uid);
        if (optional.isEmpty()) 
            throw new InvalidIDException("Invalid user ID: " + uid);
        
        return optional.get();
    }

	
	

}