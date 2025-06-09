package com.sinse.shopadmin.product.model;

// 아래의 클래스는 로직을 담기 위한 객체가 아니라, 단지 DB에서 topcategory 테이블의 레코드 1건을 담기 위한 모델 객체이다.
// 또한 이 객체는 DB의 레코드를 담고 있기 때문에 보안이 중요함.-> 은닉화
public class SubCategory {
	private int subcategory_id;
	private String sub_name;
	private TopCategory topCategory;
	
	public int getSubcategory_id() {
		return subcategory_id;
	}
	
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	
	public String getSub_name() {
		return sub_name;
	}
	
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	
	public TopCategory getTopCategory() {
		return topCategory;
	}

	public void setTopCategory(TopCategory topCategory) {
		this.topCategory = topCategory;
	}

	@Override
	public String toString() {
		return sub_name;
	}
}
