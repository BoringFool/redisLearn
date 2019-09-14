package com.zm.redis.controllerImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.redis.controller.PaymentController;
import com.zm.redis.model.Payment;
import com.zm.redis.service.PaymentService;

@Controller
@RequestMapping("/pay")
public class PaymentControllerImpl implements PaymentController {
	
	@Resource
	PaymentService service;

	@RequestMapping(value="/path",  method=RequestMethod.GET)
//	@ResponseBodyList<Payment>
	public String queryAll(HttpServletRequest req, Model model) {
//		return service.queryAll();
		
		List<Payment> lis = service.queryAll();
		model.addAttribute("payment",lis);
		return "index::zm";
	}

	@RequestMapping(value="/path/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Payment queryById(@PathVariable("id") int id) {
		return service.queryById(id);
	}

	@RequestMapping(value="/path", method=RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Payment pay) {
		service.save(pay);
	}

	@RequestMapping(value="/path", method=RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Payment pay) {
		service.update(pay);
	}

	@RequestMapping(value="/path/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
