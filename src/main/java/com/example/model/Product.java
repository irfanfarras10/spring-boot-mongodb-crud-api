package com.example.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Product {
	
	@Id
	private String id;
	private String storeId;
	private int skuSeller;
	private int stockAvailable;
	private String status;
	
	@CreatedDate()
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime updateDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public int getSkuSeller() {
		return skuSeller;
	}
	public void setSkuSeller(int skuSeller) {
		this.skuSeller = skuSeller;
	}
	public int getStockAvailable() {
		return stockAvailable;
	}
	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
