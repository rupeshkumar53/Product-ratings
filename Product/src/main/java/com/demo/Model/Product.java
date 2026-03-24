package com.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String productName;
	private String productQunity;
	private String price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer pid, String productName, String productQunity, String price) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.productQunity = productQunity;
		this.price = price;
	}
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
	
}
