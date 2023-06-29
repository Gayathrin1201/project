package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shoppingcart.model.UserInfo;
import com.example.shoppingcart.model.DeliveryMan;
import com.example.shoppingcart.model.OrderInfo;
import com.example.shoppingcart.model.ProductInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
//	@Modifying
//	@Query(value="UPDATE order_info d SET login_id = ( SELECT login_id from login_info p WHERE p.login_id=d.order_id)",nativeQuery = true)
//	    void updateUserId();

//	@Modifying
//    @Query(value="UPDATE Order d SET d.product.id = (SELECT p.id FROM Product p WHERE p.id = :productId)",nativeQuery = true)
//    void updateOrderProduct(@Param("productId") int productId);

//	 @Modifying
//	    @Query(value="UPDATE Order o SET o.product.id = :productId WHERE o.id = :orderId",nativeQuery = true)
//	    void updateOrderProduct(@Param("orderId") int orderId, @Param("productId") int productId);

	@Modifying
	@Query("UPDATE OrderInfo d SET d.productInfo = :productInfo WHERE d.orderId = :orderId")
	void updateProductByOrderId(@Param("orderId") int orderId, @Param("productInfo") ProductInfo productInfo);

	@Modifying
	@Query("UPDATE OrderInfo d SET userInfo = :userInfo WHERE d.orderId = :orderId")
	void updateUserId(@Param("orderId") int orderId, @Param("userInfo") UserInfo userInfo);
//	

	@Modifying
	@Query("UPDATE OrderInfo d SET deliveryMan = :deliveryMan WHERE d.orderId = :orderId")
	void updateDeliveryByOrderId(@Param("orderId") int orderId, @Param("deliveryMan") DeliveryMan deliveryMan);

}
