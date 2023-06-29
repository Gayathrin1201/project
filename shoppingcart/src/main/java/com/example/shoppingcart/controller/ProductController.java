package com.example.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.model.ProductInfo;
import com.example.shoppingcart.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasAuthority('ROLE_MERCHANT')")
	public ProductInfo saveProductDetails(@RequestBody ProductInfo productInfo)
	{
		return productService.addProductDetails(productInfo);
	}
	
	
	@GetMapping("/getProduct")
	@PreAuthorize("hasAuthority('ROLE_MERCHANT')")
public List<ProductInfo> getProducts()
{
		return productService.getProductDetails();
}
	
	@GetMapping("/getProduct/{id}")
	@PreAuthorize("hasAuthority('ROLE_MERCHANT')")
	public ProductInfo getByProductId(@PathVariable int id)
	{
		return productService.getProduct(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	@PreAuthorize("hasAuthority('ROLE_MERCHANT')")
	public String dropProductById(@PathVariable int id)
	{
		 productService.deleteProductById(id);
		 return "product is deleted";
	}
}
