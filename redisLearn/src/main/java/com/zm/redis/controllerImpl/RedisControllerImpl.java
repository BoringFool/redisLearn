package com.zm.redis.controllerImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.redis.controller.RedisController;
import com.zm.redis.model.RedisIntergration;
import com.zm.redis.service.RedisService;


@Controller
@RequestMapping("/test")
public class RedisControllerImpl implements RedisController {
	
	@Resource
	RedisService redisService;
	
	@RequestMapping("/redis/{value}")
	@ResponseBody
	public String save(@PathVariable String value) {
		System.out.println("=================");
		System.out.println("*****************");
		redisService.save(value);
		System.out.println("*****************");
		System.out.println("-----------------");
		redisService.saveString(value);
		System.out.println("-----------------");
		System.out.println("Controller is over!");
		System.out.println("=================");
		return "Success";
	}
	@RequestMapping("/mybatis")
//	@ResponseBody
	public String save(HttpServletRequest req) {
		System.out.println("=================");
//		redisService.testMybatis();
		RedisIntergration r = new RedisIntergration();
		r.setAge("11");
		r.setId(2);
		r.setName("zm");
		req.getSession().setAttribute("info", r);
		System.out.println("=================");
		return "index";
	}

}
