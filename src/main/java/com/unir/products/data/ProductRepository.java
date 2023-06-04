package com.unir.products.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.unir.products.model.pojo.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

	List<Product> findByName(String name);
	
	Optional<Product> findById(String id);
	
	Product save(Product product);
	
	void delete(Product product);
	
	List<Product> findAll();
}
