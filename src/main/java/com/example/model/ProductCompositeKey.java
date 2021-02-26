package com.example.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductCompositeKey implements Serializable{

	private String storeId;
	private String skuSeller;

}