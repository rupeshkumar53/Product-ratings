package com.rating.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rating.Model.ClientDTO;
import com.rating.Model.ProductDTO;
import com.rating.Model.Rating;
import com.rating.Model.RatingResponseDTO;
import com.rating.Repositry.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${client.service.url}")
	private String clientServiceUrl;

	@Value("${product.service.url}")
	private String productServiceUrl;

	public Rating ratingSave(Rating rating) {

		return ratingRepository.save(rating);
	}

	public List<RatingResponseDTO> getRatingsByProduct(String productName) {
		List<Rating> rating = ratingRepository.findByProductName(productName);

		return rating.stream().map(r -> {
			ClientDTO client[] = restTemplate.getForObject(clientServiceUrl+"/auth/" + r.getClientName(), ClientDTO[].class);

			ProductDTO product = restTemplate.getForObject(productServiceUrl + "/product/" + r.getProductName(),
					ProductDTO.class);

			RatingResponseDTO dto = new RatingResponseDTO();
			dto.setRatingId(r.getId());
			dto.setStars(r.getStars());
			dto.setFeedback(r.getFeedback());
			dto.setClient(client);
			dto.setProduct(product);

			return dto;
		}).collect(Collectors.toList());
	}

	public List<RatingResponseDTO> getRatingsByClient(String clientName) {
		List<Rating> ratings = ratingRepository.findByClientName(clientName);

		return ratings.stream().map(r -> {

			ClientDTO[] client = restTemplate.getForObject(clientServiceUrl + "/auth/" + r.getClientName(),
					ClientDTO[].class);

			ProductDTO product = restTemplate.getForObject(productServiceUrl + "/product/" + r.getProductName(),
					ProductDTO.class);

			RatingResponseDTO dto = new RatingResponseDTO();
			dto.setRatingId(r.getId());
			dto.setStars(r.getStars());
			dto.setFeedback(r.getFeedback());
			dto.setClient(client);
			dto.setProduct(product);

			return dto;
		}).collect(Collectors.toList());

	}
}