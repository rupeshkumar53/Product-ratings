package com.rating.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "clientname")
    private String clientName;
	@Column(name = "productname")
    private String productName;
    private int stars;
    private String feedback;
    
    

    public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Rating(Long id, String clientName, String productName, int stars, String feedback) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.productName = productName;
		this.stars = stars;
		this.feedback = feedback;
	}

	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}