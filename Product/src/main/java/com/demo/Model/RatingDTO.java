package com.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingDTO {

    @JsonProperty("ratingId")
    private Long ratingId;

    @JsonProperty("stars")
    private int stars;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("client")
    private ClientDTO[] client;  // ← String nahi, ClientDTO[]

    @JsonProperty("product")
    private ProductDTO product;  // ← String nahi, ProductDTO

    public Long getRatingId() { return ratingId; }
    public void setRatingId(Long ratingId) { this.ratingId = ratingId; }
    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public ClientDTO[] getClient() { return client; }
    public void setClient(ClientDTO[] client) { this.client = client; }
    public ProductDTO getProduct() { return product; }
    public void setProduct(ProductDTO product) { this.product = product; }
}