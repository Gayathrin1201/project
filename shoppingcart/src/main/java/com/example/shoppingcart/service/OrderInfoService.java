package com.example.shoppingcart.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shoppingcart.model.UserInfo;
import com.example.shoppingcart.model.DeliveryMan;
import com.example.shoppingcart.model.OrderInfo;
import com.example.shoppingcart.model.ProductInfo;
import com.example.shoppingcart.repository.UserInfoRepository;
import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.example.shoppingcart.repository.DeliveryManRepository;
import com.example.shoppingcart.repository.OrderInfoRepository;
import com.example.shoppingcart.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private UserInfoRepository loginInfoRepository;
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private DeliveryManRepository deliveryManRepository;
	
	@Value("${twilio.account_sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;

    @Value("${twilio.phone_number}")
    private String PHONE_NUMBER;
    public String generateOtp() {
        // Generate 4-digit OTP
        int otp = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
        return Integer.toString(otp);
    }
	public OrderInfo addOrder(OrderInfo orderInfo)
	{
		
		LocalDateTime currentDateTime = LocalDateTime.now();
       // OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDateTime(currentDateTime);
       
        String to=orderInfo.getTo1();
		 String otp = generateOtp();
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(new PhoneNumber(to),
	                new PhoneNumber(PHONE_NUMBER), "Your OTP is " + otp).create();
	        System.out.println("OTP message SID: " + message.getSid());
	        orderInfo.setOtp(otp);
		return orderInfoRepository.save(orderInfo);
	}
	
	public List<OrderInfo> showOrder()
	{
		return orderInfoRepository.findAll();
	}
	
	
	public OrderInfo showOrderByid(int id)
	{
		return orderInfoRepository.findById(id).get();
	}

	@Transactional
	   public void updateProductByOrderId(int orderId, int productId) {
	        Optional<ProductInfo> product = productRepository.findById(productId);
	        if (product.isPresent()) {
	            orderInfoRepository.updateProductByOrderId(orderId, product.get());
	        } else {
	            throw new IllegalArgumentException("Product not found with id " + productId);
	        }
	    }
	
	@Transactional
	   public void updateUSerByOrderId(int orderId, int userId) {
	        Optional<UserInfo> user = loginInfoRepository.findById(userId);
	        if (user.isPresent()) {
	            orderInfoRepository.updateUserId(orderId, user.get());
	        } else {
	            throw new IllegalArgumentException("user not found with id " + userId);
	        }
	    }
 
	@Transactional
	   public void updateDeliveryByOrderId(int orderId, int deliveryManId) {
	        Optional<DeliveryMan> deliveryman = deliveryManRepository.findById(deliveryManId);
	        if (deliveryman.isPresent()) {
	            orderInfoRepository.updateDeliveryByOrderId(orderId, deliveryman.get());
	        } else {
	            throw new IllegalArgumentException("DeliveryMan not found with id " + deliveryManId);
	        }
	    }

			
			   
}
