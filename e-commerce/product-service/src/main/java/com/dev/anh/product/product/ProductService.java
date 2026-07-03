package com.dev.anh.product.product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.dev.anh.product.product.exception.ProductPurchaseException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
	             .map(ProductMapper::mapToProductResponse)
	             .orElseThrow(() -> new EntityNotFoundException("Product with %s ID is not found".formatted(productId)));
    }

	public List<ProductResponse> findProducts() {
		return productRepository.findAll()
		      .stream().map(ProductMapper::mapToProductResponse)
		      .collect(Collectors.toList());
	}
	
	public Integer createProduct(ProductRequest productRequest) {
	    var product = productMapper.mapToProduct(productRequest);
		return productRepository.save(product).getId();
	}

	public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
		var productIds = request.stream()
				         .map(ProductPurchaseRequest::productId).toList();
		
		var storedProducts = productRepository.findAllByIdInOrderById(productIds);
		
		if(productIds.size() != storedProducts.size()) {
			 throw new ProductPurchaseException("Your all selected products can't be available for orders");
		}
		
		var storedRequest = request
				            .stream()
				            .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
				            .toList();
        
		var purchaseProducts = new ArrayList<ProductPurchaseResponse>();
        
		for(int i=0; i < storedProducts.size(); i++) {
			 var product = storedProducts.get(i);
			 var productRequest = storedRequest.get(i);
			 
			 if(product.getAvailableQuantity() < productRequest.quantity()) {
				  throw new ProductPurchaseException("Insufficient stock quantity for product with ID :: " + productRequest.quantity());
			 }
			 
			 var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
			 product.setAvailableQuantity(newAvailableQuantity);	
			 productRepository.save(product);
			 
			 purchaseProducts.add(ProductMapper.mapToProductPurchaseResponse(product, newAvailableQuantity));
		}
		
		return purchaseProducts;
	}

}
