package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Override
	List<User> findAll();

	//specify a method that returns User by finding it by email id
	Optional<User> findByEmailId(String emailId);

}
