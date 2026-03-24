package com.rating.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDTO {

    private Integer cid;
    private String userName;
    private String email;
    private String phone_No;
	public ClientDTO(Integer cid, String userName, String email, String phone_No) {
		super();
		this.cid = cid;
		this.userName = userName;
		this.email = email;
		this.phone_No = phone_No;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_No() {
		return phone_No;
	}
	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

}