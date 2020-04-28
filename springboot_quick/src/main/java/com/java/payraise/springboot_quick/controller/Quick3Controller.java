package com.java.payraise.springboot_quick.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix="person")
public class Quick3Controller {

	private String name;
	private String age;
	
	@RequestMapping("/quick3")
	@ResponseBody
	public String quick2() {
		return "name: "+name+",age: "+age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
