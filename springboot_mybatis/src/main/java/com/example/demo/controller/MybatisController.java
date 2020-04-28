package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Controller
public class MybatisController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/query")
	@ResponseBody
	public List<User> queryUserList(){
		List<User> users = userMapper.queryUserList();
		return users;
	}
}
