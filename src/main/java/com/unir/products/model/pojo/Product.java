package com.unir.products.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "products", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Text, name = "name")
	private String name;
	
	@Field(type = FieldType.Keyword, name = "country")
	private String country;
	
	@Field(type = FieldType.Search_As_You_Type, name = "description")
	private String description;
	
	@Field(type = FieldType.Boolean, name = "visible")
	private Boolean visible;

}
