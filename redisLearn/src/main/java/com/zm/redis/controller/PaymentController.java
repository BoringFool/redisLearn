package com.zm.redis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.zm.redis.model.Payment;

public interface PaymentController {
	public String queryAll(HttpServletRequest req, Model model);
//	public List<Payment> queryAll();
	
	public Payment queryById(int id);
	
	public void save(Payment pay);
	
	public void update(Payment pay);
	
	public void delete(int id);
}
