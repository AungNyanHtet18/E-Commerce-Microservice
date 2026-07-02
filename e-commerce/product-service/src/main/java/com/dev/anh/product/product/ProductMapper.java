package com.dev.anh.product.product;

import org.springframework.stereotype.Service;

import com.dev.anh.product.category.Category;

@Service
public class ProductMapper {

	public Product mapToProduct(ProductRequest request) {
		
		if(request == null) {
			 return null;
		}
		
		return Product.builder()
				     .id(request.id())
				     .name(request.name())
				     .description(request.description())
				     .availableQuantity(request.availableQuantity())
				     .price(request.price())
				     .category(Category
				    		 .builder()
				    		 .id(request.categoryId())
				    		 .build())
				     .build();
	}
	
	public static ProductResponse mapToProductResponse(Product product) {
		return new ProductResponse(
				product.getId(), 
				product.getName(), 
				product.getDescription(), 
				product.getAvailableQuantity(), 
				product.getPrice(), 
				product.getCategory().getId(), 
				product.getCategory().getName(), 
				product.getCategory().getDescription());
	}
}
