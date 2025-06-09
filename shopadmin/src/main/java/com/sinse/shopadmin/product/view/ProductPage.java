package com.sinse.shopadmin.product.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sinse.shopadmin.AppMain;
import com.sinse.shopadmin.common.view.Page;
import com.sinse.shopadmin.product.model.SubCategory;
import com.sinse.shopadmin.product.model.TopCategory;
import com.sinse.shopadmin.product.repository.SubCategoryDAO;
import com.sinse.shopadmin.product.repository.TopCategoryDAO;


// 상품 등록 페이지
public class ProductPage extends Page {
	JLabel la_topcategory;
	JLabel la_subcategory;
	JLabel la_product_name;
	JLabel la_brand;
	JLabel la_price;
	JLabel la_discount;
	JLabel la_color;
	JLabel la_size;
	JButton bt_open;
	JLabel la_introduce;
	JLabel la_detail;
	
	JComboBox<TopCategory> cb_topcategory;
	JComboBox cb_subcategory;
	JTextField t_product_name;
	JTextField t_brand;
	JTextField t_price;
	JTextField t_discount;
	JTextField photo;
	JTextField t_color;
	JTextField t_size;
	JPanel p_preview;
	JTextField t_introduce;
	JTextField t_detail;
	JButton bt_regist; // 상품등록
	JButton bt_list; // 상품 목록
	TopCategoryDAO topCategoryDAO;
	SubCategoryDAO subCategoryDAO;
	
	
	public ProductPage(AppMain appMain) {
		super(appMain);
		
		la_topcategory= new JLabel("최상위 카테고리");
		la_subcategory= new JLabel("하위 카테고리");
		la_product_name= new JLabel("상품명");
		la_brand= new JLabel("브랜드");
		la_price= new JLabel("가격");
		la_discount= new JLabel("할인");
		la_color= new JLabel("색상");
		la_size= new JLabel("크기");
		bt_open = new JButton("상품 이미지 등록");
		la_introduce= new JLabel("설명");
		la_detail= new JLabel("상세 설명");
		
		
		cb_topcategory = new JComboBox<>();
		cb_subcategory = new JComboBox<>();
		t_product_name = new JTextField();
		t_brand = new JTextField();
		t_price = new JTextField();
		t_discount = new JTextField();
		t_color = new JTextField();
		t_size = new JTextField();
		p_preview = new JPanel();
		t_introduce = new JTextField();
		t_detail = new JTextField();
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");
		
		topCategoryDAO = new TopCategoryDAO();
		subCategoryDAO = new SubCategoryDAO();
		
		// 스타일
		Dimension d = new Dimension(400,30);
		
		la_topcategory.setPreferredSize(d);
		la_subcategory.setPreferredSize(d);
		la_product_name.setPreferredSize(d);
		la_brand.setPreferredSize(d);
		la_price.setPreferredSize(d);
		la_discount.setPreferredSize(d);
		la_color.setPreferredSize(d);
		la_size.setPreferredSize(d);
		bt_open.setPreferredSize(d);
		la_introduce.setPreferredSize(d);
		la_detail.setPreferredSize(d);
		
		cb_topcategory.setPreferredSize(d);
		cb_subcategory.setPreferredSize(d);
		t_product_name.setPreferredSize(d);
		t_brand.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_discount.setPreferredSize(d);
		t_color.setPreferredSize(d);
		t_size.setPreferredSize(d);
		p_preview.setPreferredSize(new Dimension(400,80));
		t_introduce.setPreferredSize(new Dimension(400,50));
		t_detail.setPreferredSize(new Dimension(400,60));
		bt_regist.setPreferredSize(new Dimension(130,30));
		bt_list.setPreferredSize(new Dimension(130,30));
		
		// 조립
		add(la_topcategory);
		add(cb_topcategory);
		add(la_subcategory);
		add(cb_subcategory);
		add(la_product_name);
		add(t_product_name);
		add(la_brand);
		add(t_brand);
		add(la_price);
		add(t_price);
		add(la_discount);
		add(t_discount);
		add(la_color);
		add(t_color);
		add(la_size);
		add(t_size);
		add(bt_open);
		add(p_preview);
		add(la_introduce);
		add(t_introduce);
		add(la_detail);
		add(t_detail);
		
		add(bt_regist);
		add(bt_list);
		
		setPreferredSize(new Dimension(480,750));
		setBackground(Color.green);
		
		//최상위 카테고리에 이벤트 연결
		cb_topcategory.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					TopCategory topCategory = (TopCategory)cb_topcategory.getSelectedItem();
					
					//하위 카테고리 목록 가져오기
					List<SubCategory> subList = subCategoryDAO.selectByTop(topCategory);
					//모든 하위 카테고리 콤보아이템 지우기
					cb_subcategory.removeAllItems();
					
					//하위 카테고리 콤보박스에 넣기
					for(int i=0; i<subList.size();i++) {
						cb_subcategory.addItem(subList.get(i));
					}
				}
			}
		});
		
		// 최상위 카테고리 DB 불러오기
		getTopCategory();
		
	}
	
	// DAO를 통해 얻어온 List를 이용하여 콤보박스 채우기
	public void getTopCategory() {
		List<TopCategory> topList = topCategoryDAO.selectAll();
		TopCategory dummy = new TopCategory();
		dummy.setTop_name("상위 카테고리를 선택하세요");
		dummy.setTopcategory_id(0);
		cb_topcategory.addItem(dummy);
		
		for(int i=0;i<topList.size();i++) {
			cb_topcategory.addItem(topList.get(i));
		}
	}
}
