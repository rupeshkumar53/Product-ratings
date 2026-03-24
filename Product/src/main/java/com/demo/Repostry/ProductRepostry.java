package com.demo.Repostry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Model.Product;

@Repository
public interface ProductRepostry extends JpaRepository<Product, Integer> {

	 // List of products
    List<Product> findByProductName(String productName);
    
    // Single product - 'First' lagao
    Product findFirstByProductName(String productName);

}
