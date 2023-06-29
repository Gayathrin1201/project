package com.example.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.model.ProductInfo;
import com.example.shoppingcart.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired 
	private ProductRepository productRepository;
	
	
	public ProductInfo addProductDetails(ProductInfo productInfo) {
		return productRepository.save(productInfo);
	}
	
	
	public List<ProductInfo> getProductDetails(){
	return productRepository.findAll();
	}
	
	public ProductInfo getProduct(int id)
	{
		return productRepository.findById(id).get();
	}
	
	
	public void deleteProductById(int id)
	{
		productRepository.deleteById(id);
	}

}
