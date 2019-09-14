package com.zm.redis.mapper;

import java.util.List;

import com.zm.redis.model.Payment;

public interface PaymentMapper {
	
	public List<Payment> queryAll();
	
	public Payment queryById(int id);
	
	public void save(Payment pay);
	
	public void update(Payment pay);
	
	public void delete(int id);
}
