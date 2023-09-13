package com.dnb.devconnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devconnector.dto.User;
@Repository
public interface UserRepository extends CrudRepository<User,String>{

}
