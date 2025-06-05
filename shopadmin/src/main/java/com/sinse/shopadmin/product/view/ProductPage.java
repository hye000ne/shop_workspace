package com.sinse.shopadmin.product.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sinse.shopadmin.AppMain;
import com.sinse.shopadmin.common.view.Page;


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
	JLabel la_photo;
	JLabel la_introduce;
	JLabel la_detail;
	
	JComboBox ch_topcategory;
	JComboBox ch_subcategory;
	JTextField t_product_name;
	JTextField t_brand;
	JTextField t_price;
	JTextField photo;
	JTextField t_color;
	JTextField t_size;
	JButton bt_photo;
	JTextField t_introduce;
	JTextField t_detail;
	
	public ProductPage(AppMain appMain) {
		super(appMain);
		
		la_topcategory= new JLabel();
		la_subcategory= new JLabel();
		la_product_name= new JLabel();
		la_brand= new JLabel();
		la_price= new JLabel();
		la_discount= new JLabel();
		la_color= new JLabel();
		la_size= new JLabel();
		la_photo= new JLabel();
		la_introduce= new JLabel();
		la_detail= new JLabel();
		
		setBackground(Color.green);
		
	}
}
