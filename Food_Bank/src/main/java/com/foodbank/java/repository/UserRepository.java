package com.foodbank.java.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.foodbank.java.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserNameAndPasswordLike(String userName, String password);
	// public Optional<User> findByUserNameAndPasswordLike(UserRequestDto
	// userRequestDto);

}
