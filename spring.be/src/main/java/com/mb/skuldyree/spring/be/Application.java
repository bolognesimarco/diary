package com.mb.skuldyree.spring.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mb.skuldyree.spring.be.dao.SchoolClassRepository;
import com.mb.skuldyree.spring.be.dao.UserRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	private static UserRepository userRepository;
	
	@Autowired
	private static SchoolClassRepository schoolClassRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
