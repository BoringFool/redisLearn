package com.zm.redis.serviceImpl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zm.redis.mapper.RedisMapper;
import com.zm.redis.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {
	
	@SuppressWarnings("rawtypes")
	@Resource(name="redisTemplate")
	RedisTemplate template;
	
	@SuppressWarnings("rawtypes")
	@Resource(name="stringRedisTemplate")
	RedisTemplate StringTemplate;
	
	@Resource
	RedisMapper redisMapper;

	@SuppressWarnings("unchecked")
	@Override
	public void save(String value) {
	 	ValueOperations<String, String> op = template.opsForValue();
	 	boolean has = template.hasKey("useOfTemp");
	 	if(has) {
	 		template.delete("useOfTemp");
	 		System.out.println("======删除已存在=====");
	 	}
	 	op.set("useOfTemp", value, 3, TimeUnit.HOURS);
	 	test();
	 	System.out.println(op.get("useOfTemp"));
	 	System.out.println("Service over!");
	}
	
	@SuppressWarnings("unchecked")
	public void saveString(String value) {
		ValueOperations<String, String> op = StringTemplate.opsForValue();
		StringBuilder sd = new StringBuilder(255);
		
		boolean has = StringTemplate.hasKey("useOfString");
		if(has) {
			StringTemplate.delete("useOfString");
			System.out.println("======删除已存在=====");
		}
		
	 	op.set("useOfString", value, 3, TimeUnit.HOURS);
		test(); 
		long time = StringTemplate.getExpire("useOfString");
		
		sd.append("|value:");
		sd.append(op.get("useOfString"));
		sd.append("|");
		
		sd.append("|expireTime:");
		sd.append(time);
		sd.append("|");
		
		System.out.println(sd.toString());
		System.out.println("Service over!");
	}

	@Override
	public void testMybatis() {
		System.out.println(redisMapper.queryAll().get(0).getName());
	}
}
