package com.example.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.model.DeliveryMan;
import com.example.shoppingcart.service.DeliveryManService;

@RestController
public class DeliveryManController {
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	
	@PostMapping("/addDeliveryMan")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public DeliveryMan saveDeliveryMan(@RequestBody DeliveryMan deliveryMan)
	{
		return deliveryManService.addDeliveryMan(deliveryMan);
	}
	
	
	@GetMapping("/getDeliveryMan")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<DeliveryMan> getDelivery()
	{
		return deliveryManService.getDeliveryMan();
	}

}
