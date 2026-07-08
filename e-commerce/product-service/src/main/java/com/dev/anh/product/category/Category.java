package com.dev.anh.product.category;


import java.util.List;

import com.dev.anh.product.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	private List<Product> products;
}
