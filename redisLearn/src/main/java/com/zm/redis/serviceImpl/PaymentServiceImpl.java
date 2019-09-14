package com.zm.redis.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zm.redis.mapper.PaymentMapper;
import com.zm.redis.model.Payment;
import com.zm.redis.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Resource
	PaymentMapper paymentMap;
	
	@Resource(name="stringRedisTemplate")
	RedisTemplate<String, String> template;

	@Override
	public List<Payment> queryAll() {
		boolean has = template.hasKey("pay");
		ValueOperations<String, String> value = template.opsForValue();
		
		if(!has) {
			value.set("pay", "exits payment calue!");
		}
		
		return paymentMap.queryAll();
	}

	@Override
	public Payment queryById(int id) {
		Payment pay = paymentMap.queryById(id);
		
		boolean has = template.hasKey("pay");
		ValueOperations<String, String> value = template.opsForValue();
		if(!has) {
			value.set("pay", "exits payment id:" + pay.getId());
		}
		
		return pay;
	}

	@Override
	public void save(Payment pay) {
		paymentMap.save(pay);
	}

	@Override
	public void update(Payment pay) {
		paymentMap.update(pay);
	}	

	@Override
	public void delete(int id) {
		paymentMap.delete(id);
	}

}
