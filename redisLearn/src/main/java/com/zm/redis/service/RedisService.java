package com.zm.redis.service;

public interface RedisService {
	
	public void save(String value);
	public void saveString(String value);
	public void testMybatis();
	
	default public void test() {
		System.out.println("It worked!");
	}
}
