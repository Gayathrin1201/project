package com.example.shoppingcart.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Table
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column
	private LocalDateTime dateTime;
	//@Column
	private String to1;
	@Column
	private String otp;
	
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductInfo productInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="delivery_id")
	private DeliveryMan deliveryMan;
	public OrderInfo() {
		super();
	}
	public OrderInfo(int orderId, LocalDateTime dateTime, String to1, String otp, UserInfo userInfo,
			ProductInfo productInfo, DeliveryMan deliveryMan) {
		super();
		this.orderId = orderId;
		this.dateTime = dateTime;
		this.to1 = to1;
		this.otp = otp;
		this.userInfo = userInfo;
		this.productInfo = productInfo;
		this.deliveryMan = deliveryMan;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTo1() {
		return to1;
	}
	public void setTo1(String to1) {
		this.to1 = to1;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	

	
}
