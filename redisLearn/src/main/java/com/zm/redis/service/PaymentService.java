package com.zm.redis.service;

import java.util.List;

import com.zm.redis.model.Payment;

public interface PaymentService {
	
	public List<Payment> queryAll();
	
	public Payment queryById(int id);
	
	public void save(Payment pay);
	
	public void update(Payment pay);
	
	public void delete(int id);
}
