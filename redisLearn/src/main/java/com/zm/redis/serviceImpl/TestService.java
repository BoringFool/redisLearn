package com.zm.redis.serviceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/to")
public class TestService {
	
	@RequestMapping(value="/say/{str}", method=RequestMethod.POST)
	@ResponseBody
	public String say(@PathVariable String str) {
		System.out.println("进入控制类！");
		return str;
	}
}
