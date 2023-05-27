package com.unir.products.service;

import java.util.List;

import com.unir.products.model.pojo.Product;
import com.unir.products.model.request.CreateProductRequest;

public interface ProductsService {
	
	List<Product> getProducts(String name, String description, String country, Boolean aggregate);
	
	Product getProduct(String productId);
	
	Boolean removeProduct(String productId);
	
	Product createProduct(CreateProductRequest request);

}
