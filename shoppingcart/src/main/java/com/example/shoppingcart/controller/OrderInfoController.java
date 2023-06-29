package com.example.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.model.UserInfo;
import com.example.shoppingcart.model.OrderInfo;
//import com.example.shoppingcart.model.OtpRequest;
//import com.example.shoppingcart.model.OtpRequest;
import com.example.shoppingcart.service.OrderInfoService;
import com.twilio.exception.TwilioException;

@RestController
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;

	@PostMapping("/addOrder")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<OrderInfo> saveOrder(
			@RequestBody OrderInfo orderInfo/* , @PathVariable String to */) /* throws TwilioException */ {
		OrderInfo savedOrder = orderInfoService.addOrder(orderInfo);
		return ResponseEntity.ok(savedOrder);
	}

	@GetMapping("/getOrder")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<OrderInfo> getOrder() {
		return orderInfoService.showOrder();
	}

	@GetMapping("/getOrder/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public OrderInfo getOrderById(@PathVariable int id) {
		return orderInfoService.showOrderByid(id);
	}
	@PutMapping("/update/{orderId}/product")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void updateProductByOrderId(@PathVariable int orderId, @RequestBody Map<String, Integer> requestBody) {
		Integer productId = requestBody.get("productId");
		orderInfoService.updateProductByOrderId(orderId, productId);
		Integer userId = requestBody.get("userId");
		orderInfoService.updateUSerByOrderId(orderId, userId);
		Integer deliveryManId = requestBody.get("deliveryManId");
		orderInfoService.updateDeliveryByOrderId(orderId, deliveryManId);
	}

}
