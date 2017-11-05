package com.mb.skuldyree.spring.be.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mb.skuldyree.spring.be.dao.UserRepository;
import com.mb.skuldyree.spring.be.model.User;

@Controller
@RequestMapping(path="/api/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(path="/{id}")
	public @ResponseBody User getUser(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@GetMapping(path="/")
	public @ResponseBody User login(@RequestParam("username") String username, @RequestParam("password") String password) {
		List<User> found = repository.findByUsername(username);
		if(found == null || found.size() == 0 || !found.get(0).getPassword().equals(password)) {
			return null;
		}
		return found.get(0);
	}

}
