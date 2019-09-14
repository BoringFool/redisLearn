package com.zm.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.zm.redis.mapper")
public class RedisLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisLearnApplication.class, args);
	}

}
