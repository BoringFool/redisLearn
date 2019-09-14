package com.zm.redis.mapper;

import java.util.List;


import com.zm.redis.model.RedisIntergration;

public interface RedisMapper {
	
	public List<RedisIntergration> queryAll();
	
	public RedisIntergration queryById(int id);
	
	default public void test() {
		System.out.println("defult method can be running!");
	}

}
