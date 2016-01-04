package com.feng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		
//		redisTemplate.opsForSet().add("a", "b");
		//request.getSession().setAttribute("ff", "zoufeng");
		String name = (String) request.getSession().getAttribute("ff");
		System.out.println(name);
		System.out.println("hello world");
		return "index";
	}
}
