package com.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    private Integer pid;
    private String productName;
    private String productQunity;
    private String price;

    public ProductDTO() {} // ← yeh zaroor chahiye!

    public Integer getPid() { return pid; }
    public void setPid(Integer pid) { this.pid = pid; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductQunity() { return productQunity; }
    public void setProductQunity(String productQunity) { this.productQunity = productQunity; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}