package com.example.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.model.DeliveryMan;
import com.example.shoppingcart.repository.DeliveryManRepository;

@Service
public class DeliveryManService {
	
	@Autowired
	private DeliveryManRepository deliveryManRepository;
	
	public DeliveryMan addDeliveryMan(DeliveryMan deliveryMan)
	{
		return  deliveryManRepository.save(deliveryMan);
	}
	
	public List<DeliveryMan> getDeliveryMan()
	{
		return deliveryManRepository.findAll();
	}

}
