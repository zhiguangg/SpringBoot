package com.java.payraise.springboot_quick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/quick")
	@ResponseBody
	public String quick() {
		return "Spring Boot";
	}
}
