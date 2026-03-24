 package com.rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.Model.Rating;
import com.rating.Model.RatingResponseDTO;
import com.rating.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

   
	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping
	public ResponseEntity<Rating> ratingDetelsSave(@RequestBody Rating rating) {
		
		Rating data = ratingService.ratingSave(rating);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/product/{productName}")
    public List<RatingResponseDTO> getByProduct(@PathVariable String productName) {
        return ratingService.getRatingsByProduct(productName);
    }

    @GetMapping("/client/{clientName}")
    public List<RatingResponseDTO> getByClient(@PathVariable String clientName) {
        return ratingService.getRatingsByClient(clientName);
    }
}