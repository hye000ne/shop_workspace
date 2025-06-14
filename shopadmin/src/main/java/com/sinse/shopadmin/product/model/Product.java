package com.sinse.shopadmin.product.model;

import java.util.List;

//멤버변수가 db 컬럼명과 일치하도록한다
public class Product {
	private int product_id;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String introduce;
	private String detail;
	private SubCategory subCategory; //ERD 상에서는 자식이 부모의 pk를 숫자로 보유하지만 java 코드에선 부모를 객체형으로 보유한다.
	private List<Color> colorList; //보유 색상
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public List<Color> getColorList() {
		return colorList;
	}
	
	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
}
