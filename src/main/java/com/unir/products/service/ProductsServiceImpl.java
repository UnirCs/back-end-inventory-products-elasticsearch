package com.unir.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.products.data.DataAccessRepository;
import com.unir.products.model.pojo.Product;
import com.unir.products.model.request.CreateProductRequest;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private DataAccessRepository repository;

	@Override
	public List<Product> getProducts(String name, String description, String country, Boolean aggregate) {

		//Ahora por defecto solo devolvera productos visibles
		List<Product> products = repository.findProducts(name, description, country, aggregate);
		return products.isEmpty() ? null : products;
	}

	@Override
	public Product getProduct(String productId) {
		return repository.findById(productId).orElse(null);
	}

	@Override
	public Boolean removeProduct(String productId) {

		Product product = repository.findById(productId).orElse(null);

		if (product != null) {
			repository.delete(product);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public Product createProduct(CreateProductRequest request) {

		if (request != null && StringUtils.hasLength(request.getName().trim())
				&& StringUtils.hasLength(request.getDescription().trim())
				&& StringUtils.hasLength(request.getCountry().trim()) && request.getVisible() != null) {

			Product product = Product.builder().name(request.getName()).description(request.getDescription())
					.country(request.getCountry()).visible(request.getVisible()).build();

			return repository.save(product);
		} else {
			return null;
		}
	}

}
