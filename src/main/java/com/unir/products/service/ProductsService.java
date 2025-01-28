package com.unir.products.service;

import com.unir.products.data.model.Product;
import com.unir.products.controller.model.CreateProductRequest;
import com.unir.products.controller.model.ProductsQueryResponse;

public interface ProductsService {

	ProductsQueryResponse getProducts(String name, String description, String country, Boolean aggregate);
	
	Product getProduct(String productId);
	
	Boolean removeProduct(String productId);
	
	Product createProduct(CreateProductRequest request);

}
