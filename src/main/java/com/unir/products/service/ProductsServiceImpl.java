package com.unir.products.service;

import com.unir.products.model.response.ProductsQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.products.data.DataAccessRepository;
import com.unir.products.model.db.Product;
import com.unir.products.model.request.CreateProductRequest;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

	private final DataAccessRepository repository;

	@Override
	public ProductsQueryResponse getProducts(String name, String description, String country, Boolean aggregate) {
		//Ahora por defecto solo devolvera productos visibles
		return repository.findProducts(name, description, country, aggregate);
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
