package com.userservice.java.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.userservice.java.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String username);
}
