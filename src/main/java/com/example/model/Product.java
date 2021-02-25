package com.example.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Product {
	
	@Id
	private String storeId;
	private int skuSeller;
	private int stockAvailable;
	private String status;
	
	private LocalDateTime createdDate;

	private LocalDateTime updateDate;
	
}
