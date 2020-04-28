package com.myproject.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.jpa.domain.User;
import com.myproject.jpa.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() {
		List<User> users = userRepository.findAll();
		System.out.println(users);
	}
}
