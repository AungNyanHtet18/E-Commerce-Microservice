package com.dev.anh.product.product;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("{productId}")
	ResponseEntity<ProductResponse> findById(@PathVariable Integer productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}
	
	@GetMapping
	ResponseEntity<List<ProductResponse>> findProducts(){
		 return ResponseEntity.ok(productService.findProducts());
	}
	
	@PostMapping
	ResponseEntity<Integer> createProduct(
		@RequestBody @Valid ProductRequest productRequest) {
		return ResponseEntity.ok(productService.createProduct(productRequest));
	}
	
	@PostMapping("purchase")
	ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
		@RequestBody @Valid List<ProductPurchaseRequest> request) {
		return ResponseEntity.ok(productService.purchaseProducts(request));
	}
	
}
