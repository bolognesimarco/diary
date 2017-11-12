package com.mb.skuldyree.spring.be;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mb.skuldyree.spring.be.dao.UserRepository;
import com.mb.skuldyree.spring.be.model.Headmaster;
import com.mb.skuldyree.spring.be.model.User;
import com.mb.skuldyree.spring.be.mvc.UserController;


/**
 * Questo è lo unit test del controller e basta.
 * Infatti si usa il MockMvc che simula sia il server che la request che arriva al server
 * portandola direttamente al dispatcher di Spring e poi si mockano i dao evitando di far
 * toccare il DB. In pratica si mocka la request ed il DB e si testa solo il controller.
 * 
 * @author mbologne
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository repo;
	
	
	@Test
	public void loginSuccesses() throws Exception {
		
		Headmaster boloHm = new Headmaster();
		boloHm.setId(1);
		boloHm.setPassword("XXX");
		
		List<User> users = new ArrayList<>();
		users.add(boloHm);
		
		String boloUsername = "bolo";
		
		when(repo.findByUsername(boloUsername)).thenReturn(users);
		
		this.mockMvc.perform(get("/api/users?username=" + boloUsername + "&password=XXX"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1}"));
		
	}

}
