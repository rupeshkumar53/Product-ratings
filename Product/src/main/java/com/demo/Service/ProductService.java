package com.demo.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.Model.Product;
import com.demo.Model.ProductResponseDTO;
import com.demo.Model.RatingDTO;
import com.demo.Repostry.ProductRepostry;
@Service
public class ProductService {
	@Autowired
	private ProductRepostry productRepostry;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${rating.service.url}")
	private String ratingServiceUrl;
	public Product add(Product product) {
		
		return productRepostry.save(product);
	}
	public Product get(String pName) {
		 Product data = productRepostry.findFirstByProductName(pName);
		return data;
	}
	public List<Product> getAll() {
		
		return productRepostry.findAll();
	}
	
	public ProductResponseDTO getProductWithRatings(String pName) throws Exception {

	    Product product = productRepostry.findFirstByProductName(pName);

	    if (product == null) {
	        throw new RuntimeException("Product not found with name: " + pName);
	    }

	    List<RatingDTO> ratings = new ArrayList<>();

	    try {
	        String url = UriComponentsBuilder
	                .fromUriString(ratingServiceUrl + "/ratings/product/{name}")
	                .buildAndExpand(pName.trim())
	                .toUriString();

	        ResponseEntity<List<RatingDTO>> response = restTemplate.exchange(
	                url,
	                HttpMethod.GET,
	                null,
	                new ParameterizedTypeReference<List<RatingDTO>>() {}
	        );

	        if (response.getBody() != null) {
	            ratings = response.getBody();
	        }

	    } catch (Exception e) {
	        System.out.println("Rating service unavailable: " + e.getMessage());
	        e.printStackTrace();
	    }

	    ProductResponseDTO dto = new ProductResponseDTO();
	    dto.setPid(product.getPid());
	    dto.setProductName(product.getProductName());
	    dto.setProductQunity(product.getProductQunity());
	    dto.setPrice(product.getPrice());
	    dto.setRatings(ratings);

	    return dto;
	}
	
	
	
}