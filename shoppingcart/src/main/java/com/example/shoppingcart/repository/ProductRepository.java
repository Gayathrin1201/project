package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.model.ProductInfo;

public interface ProductRepository extends JpaRepository<ProductInfo, Integer> {

}
