package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exception.EmailIdNotFoundException;


public interface UserService {
	public User createUser(User user);

	public Optional<User> getUserById(String EmailAddress);

	public Iterable<User> getAllUsers();

	public boolean deleteUserByID(String EmailAddress) throws EmailIdNotFoundException;
}
