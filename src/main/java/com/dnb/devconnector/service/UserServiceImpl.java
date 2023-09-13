package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exception.EmailIdNotFoundException;
import com.dnb.devconnector.repo.UserRepository;



@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired // type, name
	private UserRepository userRepository;
//
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public Optional<User> getUserById(String EmailAddress) {
		// TODO Auto-generated method stub
		return userRepository.findById(EmailAddress);
		
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public boolean deleteUserByID(String EmailAddress) throws EmailIdNotFoundException {


		// TODO Auto-generated method stub

		boolean isPresent = userRepository.existsById(EmailAddress);

		if(isPresent) {

			userRepository.deleteById(EmailAddress);

			
		}else {

			throw new EmailIdNotFoundException("email not Found");

		}

		if(userRepository.existsById(EmailAddress))

			return false;

		else

			return true;

		

	}

}
