package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Product;
import com.demo.Model.ProductResponseDTO;
import com.demo.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService service;
	

	@PostMapping
	public ResponseEntity<Product> addProductDetails(@RequestBody Product product) {
		Product data = service.add(product);
		return ResponseEntity.ok(data);
	}
	@GetMapping
	public ResponseEntity<List<Product>> get() {
		List<Product> data=service.getAll();
		return ResponseEntity.ok(data);
	}
//	@GetMapping(value = "/{pName}")
//	public ResponseEntity<Product> FindByName(@PathVariable String pName) {
//		Product data=service.get(pName);
//		return ResponseEntity.ok(data);
//	}
	@GetMapping("/{pName}")
	public ProductResponseDTO getProductWithRatings(@PathVariable String pName) throws Exception {
	    return service.getProductWithRatings(pName);
	}
}
