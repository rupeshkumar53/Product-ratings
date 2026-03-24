package com.demo.Model;

import java.util.List;

public class ProductResponseDTO {
	private Integer pid;
	private String productName;
	private String productQunity;
	private String price;
	private List<RatingDTO> ratings;

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQunity() {
		return productQunity;
	}
	public void setProductQunity(String productQunity) {
		this.productQunity = productQunity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<RatingDTO> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingDTO> ratings) {
		this.ratings = ratings;
	}
}