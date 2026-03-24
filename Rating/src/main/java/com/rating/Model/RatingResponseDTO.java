package com.rating.Model;

public class RatingResponseDTO {
    private Long ratingId;
    private int stars;
    private String feedback;
    private ClientDTO[] client;
    private ProductDTO product;

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