package com.example.shoppingcart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DeliveryMan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryManId;
	@Column
	private String deliveryManName;
	
	@Column
	private long contact;

	public DeliveryMan() {
		super();
	}

	public DeliveryMan(int deliveryManId, String deliveryManName, long contact) {
		super();
		this.deliveryManId = deliveryManId;
		this.deliveryManName = deliveryManName;
		this.contact = contact;
	}

	public int getDeliveryManId() {
		return deliveryManId;
	}

	public void setDeliveryManId(int deliveryManId) {
		this.deliveryManId = deliveryManId;
	}

	public String getDeliveryManName() {
		return deliveryManName;
	}

	public void setDeliveryManName(String deliveryManName) {
		this.deliveryManName = deliveryManName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	
	

}
