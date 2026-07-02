package com.dev.anh.product.product;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	public ProductResponse findById(Integer productId) {
        var productResponse = productRepository.findById(productId)
        		             .map(ProductMapper::mapToProductResponse)
        		             .orElseThrow(() -> new EntityNotFoundException("Product with %s ID is not found".formatted(productId)));
        
		return productResponse;
	}

	public List<ProductResponse> findProducts() {
		
		return null;
	}
	
	public Integer createProduct(ProductRequest productRequest) {
      var product = productMapper.mapToProduct(productRequest);
	  return productRepository.save(product).getId();
	}

	public List<ProductPurchaseResponse> purchaseProducts(@Valid List<ProductPurchaseRequest> request) {
		
		return null;
	}

}
