package com.mb.skuldyree.spring.be.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mb.skuldyree.spring.be.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByUsername(String username);
}
