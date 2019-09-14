package com.zm.redis.model;

import java.io.Serializable;

public class RedisIntergration implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String age;

	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
