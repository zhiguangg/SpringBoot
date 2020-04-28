package com.myproject.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.jpa.domain.User;
import com.myproject.jpa.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringbootJpaApplication.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() throws JsonProcessingException {
		//1. get data from Redis, data is in json format
		String userListJson = redisTemplate.boundValueOps("user.findAll").get();
		//2. determine if data exist in Redis
		if(null==userListJson) {
			//3. if data do not exist, get from database
			List<User> users = userRepository.findAll();
			//4. save users into Redis
			ObjectMapper objectMapper = new ObjectMapper();
			userListJson = objectMapper.writeValueAsString(users);
			redisTemplate.boundValueOps("user.findAll").set(userListJson);
			System.out.println("----get user info from database-----");
		} else {
			System.out.println("----get user info from redis----");
		}
		//4. print out data
		System.out.println(userListJson);
	}
}
