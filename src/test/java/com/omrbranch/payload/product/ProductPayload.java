package com.omrbranch.payload.product;

import com.omrbranch.Product.Pojo.SearchProduct_Input_Pojo;

public class ProductPayload {
	public SearchProduct_Input_Pojo searchProduct(String text) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo=new SearchProduct_Input_Pojo(text);
		return searchProduct_Input_Pojo; 

	}

}
