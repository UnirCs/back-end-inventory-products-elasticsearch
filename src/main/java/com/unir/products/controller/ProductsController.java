package com.unir.products.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.unir.products.model.response.ProductsQueryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unir.products.model.db.Product;
import com.unir.products.model.request.CreateProductRequest;
import com.unir.products.service.ProductsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

	private final ProductsService service;

	@GetMapping("/products")
	public ResponseEntity<ProductsQueryResponse> getProducts(
			@RequestHeader Map<String, String> headers,
			@RequestParam(required = false) String description, 
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String country,
			@RequestParam(required = false, defaultValue = "false") Boolean aggregate) {

		log.info("headers: {}", headers);
		ProductsQueryResponse products = service.getProducts(name, description, country, aggregate);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable String productId) {

		log.info("Request received for product {}", productId);
		Product product = service.getProduct(productId);

		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {

		Boolean removed = service.removeProduct(productId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/products")
	public ResponseEntity<Product> getProduct(@RequestBody CreateProductRequest request) {

		Product createdProduct = service.createProduct(request);

		if (createdProduct != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

}
