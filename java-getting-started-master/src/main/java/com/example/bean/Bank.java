package com.example.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {

	 private String ifsc;
	 private String branch ;
	 private String city;
	 private String address;
	 private String district;
	 private String state;
	 private String bankName;
	 

 @JsonCreator
 public Bank(@JsonProperty("ifsc") String ifsc,
		   @JsonProperty("branch") String branch, @JsonProperty("city") String city,
		   @JsonProperty("address") String address,@JsonProperty("bankName") String bankName,
		   @JsonProperty("district") String district,@JsonProperty("state") String state)  {
  this.ifsc=ifsc;
  this.branch=branch;
  this.city=city;
  this.address=address;
  this.district=district;
  this.state=state;
  this.bankName=bankName;
 }

 public Bank() {
 }

public String getIfsc() {
	return ifsc;
}

public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getDistrict() {
	return district;
}

public void setDistrict(String district) {
	this.district = district;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

@Override
 public String toString() {
  StringBuilder str = new StringBuilder();
  str.append(" ifsc:- " + getIfsc());
  str.append(" bank Name:- " + getBankName());
  str.append(" address:- " + getAddress());
  str.append(" city:- " + getCity());
  str.append(" district:- " + getDistrict());
  str.append(" state:- " + getState());
  return str.toString();
 }
}


